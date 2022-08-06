package com.example.myfirsttrying.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_products")
public class UsersProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int users_id;
    @Column
    private int products_id;

    public UsersProducts(int users_id, int products_id) {
        this.users_id = users_id;
        this.products_id = products_id;
    }
}
