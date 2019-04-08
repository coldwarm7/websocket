package com.coldwarm7.websocket.controller;

import com.coldwarm7.websocket.model.Glossary;
import com.coldwarm7.websocket.VO.Message;
import com.coldwarm7.websocket.model.User;
import com.coldwarm7.websocket.service.GlossaryService;
import com.coldwarm7.websocket.service.IntermediateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/translateApp")
public class GlossaryController {
    @Autowired
    private GlossaryService glossaryService;
    @Autowired
    private IntermediateService intermediateService;

    @PostMapping("/addGlossary")
    public Message addGlossary(@RequestParam int id,@RequestParam String english){
        glossaryService.addGlossary(english);
        ArrayList<User> users  = new ArrayList<>();
        Message message = new Message();
        Glossary glossary = glossaryService.findByEnglish(english);
        intermediateService.addIntermediate(id,glossary.getId());
        message.setData(users);
        message.setCode(true);
        return message;
    }

    @PostMapping("/findByUserId")
    public Message findByUserId(@RequestParam int id){
        List<Optional<Glossary>> glossaryServiceByUserId = glossaryService.findByUserId(id);
        Message message = new Message();
        message.setData(glossaryServiceByUserId);
        if (glossaryServiceByUserId.size() == 0){
            message.setCode(false);
            message.setCount(0);
        }else {
            message.setCount(glossaryServiceByUserId.size());
            message.setCode(true);
        }
        return message;
    }
}
