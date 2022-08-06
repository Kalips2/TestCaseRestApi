package com.example.myfirsttrying.Services;

import com.example.myfirsttrying.DTO.ProductDTO;
import com.example.myfirsttrying.DTO.UserDTO;
import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<Product> getAllProducts();
    void ImplPurchase(int user_id, int item_id) throws Exception;
    List<User> getUserByProduct(int id);
    List<Product> getProductByUser(int id);
    void addUser(UserDTO user);
    void addProduction(ProductDTO item);

    void deleteUser(int id);
    void deleteProduct(int id);

}
