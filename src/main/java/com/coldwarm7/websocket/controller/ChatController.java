package com.coldwarm7.websocket.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.coldwarm7.websocket.model.Message;
import com.coldwarm7.websocket.model.User;
import com.coldwarm7.websocket.service.UserService;
import com.coldwarm7.websocket.websocket.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;




import com.google.gson.GsonBuilder;

@RequestMapping("/translateApp")
@Controller
public class ChatController {
    @Autowired
    MyWebSocketHandler handler;

    @Autowired
    UserService loginservice;

    @RequestMapping("/onlineusers")
    @ResponseBody
    public Set<String> onlineusers(HttpSession session){
        Map<Integer, WebSocketSession> map=MyWebSocketHandler.userSocketSessionMap;
        Set<Integer> set=map.keySet();
        Iterator<Integer> it = set.iterator();
        Set<String> nameset=new HashSet<String>();
        while(it.hasNext()){
            Integer entry = it.next();
            String name=loginservice.getnamebyid(entry);
            String user=(String)session.getAttribute("username");
            if(!user.equals(name))
                nameset.add(name);
        }
        return nameset;
    }

    // 发布系统广播（群发）
    @ResponseBody
    @RequestMapping(value = "broadcast", method = RequestMethod.POST)
    public void broadcast(@RequestParam("text") String text) throws IOException {
        Message msg = new Message();
        msg.setDate(new Date());
        msg.setFrom(-1L);//-1表示系统广播
        msg.setFromName("系统广播");
        msg.setTo((int) 0L);
        msg.setText(text);
        handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
    }

    @RequestMapping("getuid")
    @ResponseBody
    public User getuid(@RequestParam("username")String username){
        return loginservice.findByUsername(username);
    }
}
