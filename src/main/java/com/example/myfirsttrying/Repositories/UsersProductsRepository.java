package com.example.myfirsttrying.Repositories;

import com.example.myfirsttrying.Models.UsersProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersProductsRepository extends JpaRepository<UsersProducts, Integer> {

}
