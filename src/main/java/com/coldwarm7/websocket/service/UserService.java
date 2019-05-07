package com.coldwarm7.websocket.service;

import com.coldwarm7.websocket.dao.UserDao;
import com.coldwarm7.websocket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByUsername(String username){
        User u = null;
        try {
            u =  userDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean addUser(String username,String password){
        if (findByUsername(username) != null){
            return false;
        }
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userDao.save(user);
        return true;
    }

    public String getnamebyid(int uid){
        User user = null;
        try {
            user = userDao.findById(uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user.getUsername();
    }

}
