package com.luv2code.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import com.luv2code.ecommerce.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join Customer u\s
      on t.customer.customerId = u.id\s
      where u.customerId = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByCustomer(Integer id);

    @Query(value = """
      select t from Token t inner join Seller u\s
      on t.seller.sellerId = u.id\s
      where u.sellerId = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenBySeller(Integer id);

    Optional<Token> findByToken(String token);
}
