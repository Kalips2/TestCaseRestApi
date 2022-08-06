package com.example.myfirsttrying.Services;

import com.example.myfirsttrying.DTO.ProductDTO;
import com.example.myfirsttrying.DTO.UserDTO;
import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<Product> getAllProducts();
    void ImplPurchase(int user_id, int item_id);
    List<User> getUserByProduct();
    List<Product> getProductByUser();
    void addUser(UserDTO user);
    void addProduction(ProductDTO item);

}
