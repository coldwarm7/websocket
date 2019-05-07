package com.coldwarm7.websocket.dao;

import com.coldwarm7.websocket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findById(int id);

}
