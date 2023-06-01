package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.model.entity.Customer;
import com.luv2code.ecommerce.model.entity.Seller;
import com.luv2code.ecommerce.service.CustomerService;
import com.luv2code.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class UserController {

    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final SellerService sellerService;
    public UserController( CustomerService customerService, SellerService sellerService) {
        this.customerService = customerService;
        this.sellerService = sellerService;
    }


    @GetMapping("/customer")
    public Customer getCustomer(Authentication authentication) {
        String username = authentication.getName();
        return customerService.getUserByUsername(username);
    }

    @GetMapping("/seller")
    public Seller getSeller(Authentication authentication) {
        String username = authentication.getName();
        return sellerService.getUserByUsername(username);
    }
}
