package com.example.myfirsttrying.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //ManyToMany
    @ManyToMany
    @JoinTable(
            name="users_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<User> users;

    public Product() {

    }
}
