package com.luv2code.ecommerce.Controller;

import com.luv2code.ecommerce.model.dto.request.AuthenticationRequest;
import com.luv2code.ecommerce.model.dto.response.AuthenticationResponse;
import com.luv2code.ecommerce.service.AuthenticationService;
import com.luv2code.ecommerce.model.dto.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register/customer")
    public ResponseEntity<AuthenticationResponse> registerCustomer(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerCustomer(request));
    }
    @PostMapping("/register/seller")
    public ResponseEntity<AuthenticationResponse> registerSeller(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerSeller(request));
    }
    @PostMapping("/authenticate/customer")
    public ResponseEntity<AuthenticationResponse> authenticateCustomer(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("Error");
        return ResponseEntity.ok(service.authenticateCustomer(request));
    }
    @PostMapping("/authenticate/seller")
    public ResponseEntity<AuthenticationResponse> authenticateSeller(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("Error");
        return ResponseEntity.ok(service.authenticateSeller(request));
    }


}
