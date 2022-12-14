package com.example.myfirsttrying.Controllers;

import com.example.myfirsttrying.DTO.ProductDTO;
import com.example.myfirsttrying.DTO.UserDTO;
import com.example.myfirsttrying.Models.Product;
import com.example.myfirsttrying.Services.UserServiceImpl;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PutMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserDTO user) {
        service.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductDTO item) {
        service.addProduction(item);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/allUser")
    public ResponseEntity allUser() {
        return new ResponseEntity(service.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/allProduct")
    public ResponseEntity allProduct() {
        return new ResponseEntity(service.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/buy")
    public ResponseEntity ImpPurchase(@RequestParam int user_id, @RequestParam int item_id) {
        try {
            service.ImplPurchase(user_id, item_id);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity getUserByProduct(@PathVariable int id) {
        return new ResponseEntity(service.getUserByProduct(id), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity getProductByUser(@PathVariable int id) {
        return new ResponseEntity(service.getProductByUser(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
