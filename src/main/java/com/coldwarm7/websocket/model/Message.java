package com.coldwarm7.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    //发送者
    public Long from;
    //发送者名称
    public String fromName;
    //接收者
    public Integer to;
    //发送的文本
    public String text;
    //发送日期
    public Date date;
}
