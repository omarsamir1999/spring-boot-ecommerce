package com.luv2code.ecommerce.Controller;

import com.luv2code.ecommerce.dao.UserRepository;
import com.luv2code.ecommerce.entity.Category;
import com.luv2code.ecommerce.entity.User;
import com.luv2code.ecommerce.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("user")
    public User getUser(Authentication authentication) {
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }
}
