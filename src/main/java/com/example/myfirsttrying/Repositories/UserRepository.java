package com.example.myfirsttrying.Repositories;

import com.example.myfirsttrying.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update User e set e.amount_money=:money where e.id=:id")
    void ChangeMoney(@Param("id") int user_id, @Param("money") int money);
}
