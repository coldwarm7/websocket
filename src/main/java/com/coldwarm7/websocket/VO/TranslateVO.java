package com.coldwarm7.websocket.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateVO {
    private boolean code;
    private Object data;
    private String tSpeakUrl;
    private String English;
    private String chinese;
}
