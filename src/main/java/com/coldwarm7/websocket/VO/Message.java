package com.coldwarm7.websocket.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private boolean code;
    private Object data;
    private int count;
}
