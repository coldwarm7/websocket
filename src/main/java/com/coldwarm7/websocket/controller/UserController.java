package com.coldwarm7.websocket.controller;

import com.coldwarm7.websocket.VO.Message;
import com.coldwarm7.websocket.model.User;
import com.coldwarm7.websocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/translateApp")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Message login(@RequestParam String username,@RequestParam String password){
        User user = userService.findByUsername(username);
        ArrayList<User> users  = new ArrayList<>();
        Message message = new Message();
        if (user == null){
            message.setData(users);
            message.setCode(false);
            return message;
        }
        if (user.getPassword().equals(password)){
            message.setCode(true);
            users.add(user);
            message.setData(users);
            return message;
        }
        message.setData(users);
        message.setCode(false);
        return message;
    }
    @PostMapping("/register")
    public Message register(@RequestParam String username,@RequestParam String password){
        ArrayList<User> users  = new ArrayList<>();
        Message message = new Message();
        boolean result = userService.addUser(username,password);
        if (result == false){
            message.setCode(false);
            message.setData(users);
            return message;
        }
        message.setCode(true);
        message.setData(users);
        return message;
    }
}
