package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.converter.ClassConverter;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.enums.Role;
import com.example.spring.demo.exception.InvalidInputException;
import com.example.spring.demo.pojos.LoginDto;
import com.example.spring.demo.pojos.RegisterDto;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.repository.UserRepo;
import com.example.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ResponseManager responseManager;

    @Autowired
    private ClassConverter con;

    @Autowired
    private HttpSession session;



    @Override
    public ApiResponse createOwner(RegisterDto adminRegisterDto) {
        validateUser(adminRegisterDto);
        User entity = con.convertDTOtoEntity(adminRegisterDto);
        entity.setRole(Role.ADMIN.name());// converting enum roles to string

        userRepo.save(entity);
        return responseManager.success(entity);
    }

    @Override
    public ApiResponse createUser(RegisterDto userRegisterDto) {
        validateUser(userRegisterDto);
        User entity = con.convertDTOtoEntity(userRegisterDto);
        entity.setRole(Role.CUSTOMER.name());// converting enum roles to string

        userRepo.save(entity);
        return responseManager.success(entity);
    }

    @Override
    public ApiResponse loginUser(LoginDto request) {

        if (request.getUserName() == null)
            return responseManager.error("Email required!");
        else if (request.getPassWord() == null)
            return responseManager.error("Password required!");

        session.setAttribute("loginStatus",true);


        return responseManager.success(request);
    }

    public void validateUser(RegisterDto registerDto){
        boolean emailExist = userRepo.existsByEmail(registerDto.getEmail());
        if (registerDto.getUserName() == null)
            throw new InvalidInputException("Name cannot be null","Name required!");
        else if ((registerDto.getEmail() == null))
            throw new InvalidInputException("email cannot be null","email required!");
        else if (registerDto.getPassword() == null)
            throw new InvalidInputException("Password cannot be null","password required!");

        if(emailExist)
            throw new InvalidInputException("User already exist","Please Login!");
    }
    public String logOut(){
        session.invalidate();
        return "Logged Out Successfully";
    }
}
