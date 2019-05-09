package com.coldwarm7.websocket.controller;

import com.coldwarm7.websocket.VO.Message;
import com.coldwarm7.websocket.model.User;
import com.coldwarm7.websocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("/translateApp")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Message login(@RequestParam String username,@RequestParam String password,HttpSession httpSession){
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
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("uid",user.getId());
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
    @PostMapping("/changePassword")
    public Message changePassword(@RequestParam String newPassword,@RequestParam String oldPassword,@RequestParam int id){
        boolean result = userService.changePassword(newPassword,oldPassword,id);
        Message message = new Message();
        if (result == true){
            message.setCode(true);
            return message;
        }
        message.setCode(false);
        return message;
    }
}
