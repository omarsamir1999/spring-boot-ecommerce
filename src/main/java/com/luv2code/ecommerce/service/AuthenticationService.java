package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.model.dto.request.AuthenticationRequest;
import com.luv2code.ecommerce.model.dto.response.AuthenticationResponse;
import com.luv2code.ecommerce.model.dto.request.RegisterRequest;
import com.luv2code.ecommerce.dao.SellerRepository;
import com.luv2code.ecommerce.dao.TokenRepository;
import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.model.entity.*;
import com.luv2code.ecommerce.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerCustomer(RegisterRequest request) {
        var customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .build();
        var savedUser = customerRepository.save(customer);
        var jwtToken = jwtService.generateToken(customer);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse registerSeller(RegisterRequest request) {
        var seller = Seller.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        var savedSeller = sellerRepository.save(seller);
        var jwtToken = jwtService.generateToken(seller);
        saveSellerToken(savedSeller, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticateSeller(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var seller = sellerRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(seller);
        revokeAllSellerTokens(seller);
        saveSellerToken(seller, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticateCustomer(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(customer);
        revokeAllCustomerTokens(customer);
        saveUserToken(customer, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    private void saveUserToken(Customer user, String jwtToken) {
        var token = Token.builder()
                .customer(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void saveSellerToken(Seller seller, String jwtToken) {
        var token = Token.builder()
                .seller(seller)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllCustomerTokens(Customer customer) {
        var validCustomerTokens = tokenRepository.findAllValidTokenByCustomer(customer.getCustomerId());
        if (validCustomerTokens.isEmpty())
            return;
        validCustomerTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validCustomerTokens);
    }
    private void revokeAllSellerTokens(Seller seller) {
        var validSellerTokens = tokenRepository.findAllValidTokenBySeller(seller.getSellerId());
        if (validSellerTokens.isEmpty())
            return;
        validSellerTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validSellerTokens);
    }
}
