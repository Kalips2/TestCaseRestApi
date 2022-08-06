package com.example.myfirsttrying.Services;

import com.example.myfirsttrying.DTO.ProductDTO;
import com.example.myfirsttrying.DTO.UserDTO;
import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Models.User;
import com.example.myfirsttrying.Repositories.ProductRepository;
import com.example.myfirsttrying.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void ImplPurchase(int user_id, int item_id) {
        User user = userRepository.getReferenceById(user_id);

    }

    @Override
    public List<User> getUserByProduct() {
        return null;
    }

    @Override
    public List<Product> getProductByUser() {
        return null;
    }

    @Override
    public void addUser(UserDTO user) {
        userRepository.save(new User(user.getFirst_name(), user.getLast_name(), user.getAmount_money()));
    }

    @Override
    public void addProduction(ProductDTO item) {
        productRepository.save(new Product(item.getName(), item.getPrice()));
    }
}
