package com.example.myfirsttrying.Services;

import com.example.myfirsttrying.DTO.ProductDTO;
import com.example.myfirsttrying.DTO.UserDTO;
import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Models.User;
import com.example.myfirsttrying.Models.UsersProducts;
import com.example.myfirsttrying.Repositories.ProductRepository;
import com.example.myfirsttrying.Repositories.UserRepository;
import com.example.myfirsttrying.Repositories.UsersProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional //Чтобы мы могли выполнять запросы (query)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UsersProductsRepository usersProductsRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void ImplPurchase(int user_id, int item_id) throws Exception {
        User user = userRepository.getReferenceById(user_id);
        Product item = productRepository.getReferenceById(item_id);
        //System.out.println(user);
        //System.out.println(item);
        int money = user.getAmount_money();
        int cost = item.getPrice();
        if (money < cost) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "You can't afford this product! Choose another one!"
            );
        } else {
            userRepository.ChangeMoney(user_id, money - cost);
            usersProductsRepository.save(new UsersProducts(user_id, item_id));
        }
    }

    @Override
    public List<User> getUserByProduct(int id) {
        return usersProductsRepository.getUserByProduct(id);
    }

    @Override
    public List<Product> getProductByUser(int id) {
        return usersProductsRepository.getProductByUser(id);
    }

    @Override
    public void addUser(UserDTO user) {
        userRepository.save(new User(user.getFirst_name(), user.getLast_name(), user.getAmount_money()));
    }

    @Override
    public void addProduction(ProductDTO item) {
        productRepository.save(new Product(item.getName(), item.getPrice()));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
