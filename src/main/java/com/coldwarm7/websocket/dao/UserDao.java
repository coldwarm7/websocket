package com.coldwarm7.websocket.dao;

import com.coldwarm7.websocket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findById(int id);

    @Modifying
    @Query("update User a set a.password=?1 where a.id=?2")
    void changePassword(String password,int id);

}
