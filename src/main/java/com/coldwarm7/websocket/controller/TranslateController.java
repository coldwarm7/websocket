package com.coldwarm7.websocket.controller;

import com.coldwarm7.websocket.VO.Message;
import com.coldwarm7.websocket.VO.TranslateVO;
import com.coldwarm7.websocket.utils.TranslateAPI;
import com.coldwarm7.websocket.utils.TranslateJSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/translateApp")
public class TranslateController {

    @PostMapping("/translateToZH")
    public TranslateVO translateToZH(@RequestParam String english) throws IOException {
        TranslateAPI translateAPI = new TranslateAPI();
        TranslateVO translateJSON = translateAPI.translateToZH(english);
        return translateJSON;
    }
    @PostMapping("/translateToEN")
    public TranslateVO translaToEN(@RequestParam String chinese) throws IOException {
        TranslateAPI translateAPI = new TranslateAPI();
        TranslateVO translateJSON = translateAPI.translateToEN(chinese);
        return translateJSON;
    }

}
