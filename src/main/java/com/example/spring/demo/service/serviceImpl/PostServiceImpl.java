package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.converter.ClassConverter;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.enums.Role;
import com.example.spring.demo.enums.Title;
import com.example.spring.demo.exception.UnauthorizedAccessException;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.repository.PostRepo;
import com.example.spring.demo.repository.UserRepo;
import com.example.spring.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private HttpSession session;

    @Autowired
    private ClassConverter classConverter;

    @Autowired
    private ResponseManager responseManager;


    @Override
    public PostDto createPost(PostDto postDto, Long userId) {
        if (session.getAttribute("loginStatus") == null){
            throw new UnauthorizedAccessException("Access Denied","Kindly Login");
        }
        if (!userRepo.existsByUserIdAndRole(userId, Role.ADMIN.name())){
            throw new UnauthorizedAccessException("Access Denied","Contact Admin");
        }

        Post post = classConverter.convertPostDTOtoEntity(postDto);

        post = postRepo.save(post);

        postDto.setId(post.getPostId());
        postDto.setTitle(post.getTitle());
        postDto.setCategory(post.getCategory());
        postDto.setDescription(post.getDescription());
        postDto.setPrice(post.getPrice());
        return postDto;
    }


    @Override
    public ApiResponse getAllPost() {

        List<PostDto> postDtoList = postRepo.findAll()
                .stream()
                .map(post -> PostDto.builder()
                        .Id(post.getPostId())
                        .title(post.getTitle())
                        .price(post.getPrice())
                        .category(post.getCategory())
                        .description(post.getDescription())
                        .numberOfLikes(post.getLikes().size())
//                        .comments(commentRepo.findAllByPostId(post.getPostId()).orElse(new ArrayList<>()))
                        .build())
                .collect(Collectors.toList());

        return responseManager.success(postDtoList);
    }

    @Override
    public PostDto getPostById(Long postId){
       return postRepo.findById(postId).map(post -> PostDto.builder()
               .Id(post.getPostId())
               .title(post.getTitle())
               .price(post.getPrice())
               .category(post.getCategory())
               .description(post.getDescription())
//               .comments(commentRepo.findAllByPostId(post.getPostId()).orElse(new ArrayList<>()))
               .build()).orElse(new PostDto());
    }

    @Override
    public ApiResponse viewPostByTitle(Title title) {
        List<Post> post = new ArrayList<>();
        if (!post.isEmpty())
            return responseManager.error("No Such Post Available");
        else
            postRepo.viewByTitle(title.toString()).forEach(post::add);
            return responseManager.success(post);
    }

    @Override
    public ApiResponse updatePost(Long postId, PostDto postDto) {
        Optional<Post> postOptional = postRepo.findById(postId);
        Post postUpdate = postOptional.orElseThrow(() ->
                new NoSuchElementException("post with id " + postId + " Not found."));
        String title = String.valueOf(postDto.getTitle());
        String category = postDto.getCategory();
        String description = postDto.getDescription();
        Double price = postDto.getPrice();

        if (title != null){
            postUpdate.setTitle(postDto.getTitle());
        }
        if (category != null) {
            postUpdate.setCategory(postDto.getCategory());
        }
        if (description != null) {
            postUpdate.setDescription(postDto.getDescription());
        }
        if (price != null) {
            postUpdate.setPrice(postDto.getPrice());
        }

        return responseManager.success(postRepo.save(postUpdate));
    }
    public ApiResponse deletePost (Long postId){
        postRepo.deleteById(postId);
        return responseManager.success(postId);
    }

}
