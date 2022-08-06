package com.example.myfirsttrying.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "amount_money")
    private int amount_money;

    //ManyToMany
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="users_products",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;


    public User(String first_name, String last_name, int amount_money) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.amount_money = amount_money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", amount_money=" + amount_money +
                ", products=" + products +
                '}';
    }
}
