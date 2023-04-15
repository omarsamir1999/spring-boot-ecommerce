package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.entity.User;
import com.luv2code.ecommerce.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
