package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.converter.ClassConverter;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.pojos.RegisterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassConverterTest {
    @InjectMocks
    private ClassConverter classConverter;

    @Test
    void testConvertDTOtoEntity_Success(){

        RegisterDto dto = new RegisterDto();
        dto.setUserName("Dummy");
        dto.setPassword("12345");

        User user = classConverter.convertDTOtoEntity(dto);

        Assertions.assertEquals(dto.getUserName(), user.getUserName());
        Assertions.assertEquals(dto.getUserName(), user.getUserName());

    }

    @Test
    void testConvertEntityToDTO_Success(){

        PostDto dto = new PostDto();
        dto.setCategory("Dummy");
        dto.setPrice(12345.55);

        Post post = classConverter.convertPostDTOtoEntity(dto);

        Assertions.assertEquals(dto.getPrice(), post.getPrice());
        Assertions.assertEquals(dto.getCategory(), post.getCategory());
    }
}
