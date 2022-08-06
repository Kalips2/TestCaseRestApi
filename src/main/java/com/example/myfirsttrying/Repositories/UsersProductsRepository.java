package com.example.myfirsttrying.Repositories;

import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Models.User;
import com.example.myfirsttrying.Models.UsersProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProductsRepository extends JpaRepository<UsersProducts, Integer> {

    @Query("SELECT a \n" +
            "FROM User a INNER JOIN UsersProducts b ON a.id = b .users_id\n" +
            "WHERE b .products_id=:id")
    List<User> getUserByProduct(@Param("id") int item_id);

    @Query("SELECT a FROM Product a INNER JOIN UsersProducts b ON a.id = b.products_id\n" +
            "WHERE b.users_id=:id")
    List<Product> getProductByUser(@Param("id") int user_id);
}
