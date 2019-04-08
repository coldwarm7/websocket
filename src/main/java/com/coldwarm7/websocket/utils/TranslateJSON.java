package com.coldwarm7.websocket.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslateJSON {

    /**
     * tSpeakUrl : http://openapi.youdao.com/ttsapi?q=%E5%AE%89%E5%8D%93&langType=zh-CHS&sign=5C601B9AF51A0F0D0445CCE8F133CF19&salt=1554722128335&voice=4&format=mp3&appKey=6361609dfc7ee52c
     * web : [{"value":["人型机器人学"],"key":"android science"},{"value":["下载和安装","安装","简介"],"key":"Android NDK"},{"value":["操作系统","安卓操作系统","安卓系统","作业系统"],"key":"Android OS"}]
     * query : android
     * translation : ["安卓"]
     * errorCode : 0
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=android"}
     * webdict : {"url":"http://m.youdao.com/dict?le=eng&q=android"}
     * basic : {"us-phonetic":"'ændrɔɪd","phonetic":"'ændrɒɪd","uk-phonetic":"'ændrɒɪd","uk-speech":"http://openapi.youdao.com/ttsapi?q=android&langType=en&sign=E8E8E8D41FA45A5DF437C58DAA5DE080&salt=1554722128335&voice=5&format=mp3&appKey=6361609dfc7ee52c","explains":["n. 机器人"],"us-speech":"http://openapi.youdao.com/ttsapi?q=android&langType=en&sign=E8E8E8D41FA45A5DF437C58DAA5DE080&salt=1554722128335&voice=6&format=mp3&appKey=6361609dfc7ee52c"}
     * l : en2zh-CHS
     * speakUrl : http://openapi.youdao.com/ttsapi?q=android&langType=en&sign=E8E8E8D41FA45A5DF437C58DAA5DE080&salt=1554722128335&voice=4&format=mp3&appKey=6361609dfc7ee52c
     */

    private String tSpeakUrl;
    private String English;
    //private String errorCode;
    //private DictBean dict;
   // private WebdictBean webdict;
    //private BasicBean basic;
    //private String l;
    //private String speakUrl;
    //private List<WebBean> web;
    private String chinese;


    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=android
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WebdictBean {
        /**
         * url : http://m.youdao.com/dict?le=eng&q=android
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class BasicBean {
        /**
         * us-phonetic : 'ændrɔɪd
         * phonetic : 'ændrɒɪd
         * uk-phonetic : 'ændrɒɪd
         * uk-speech : http://openapi.youdao.com/ttsapi?q=android&langType=en&sign=E8E8E8D41FA45A5DF437C58DAA5DE080&salt=1554722128335&voice=5&format=mp3&appKey=6361609dfc7ee52c
         * explains : ["n. 机器人"]
         * us-speech : http://openapi.youdao.com/ttsapi?q=android&langType=en&sign=E8E8E8D41FA45A5DF437C58DAA5DE080&salt=1554722128335&voice=6&format=mp3&appKey=6361609dfc7ee52c
         */

        @com.google.gson.annotations.SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @com.google.gson.annotations.SerializedName("uk-phonetic")
        private String ukphonetic;
        @com.google.gson.annotations.SerializedName("uk-speech")
        private String ukspeech;
        @com.google.gson.annotations.SerializedName("us-speech")
        private String usspeech;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public String getUkspeech() {
            return ukspeech;
        }

        public void setUkspeech(String ukspeech) {
            this.ukspeech = ukspeech;
        }

        public String getUsspeech() {
            return usspeech;
        }

        public void setUsspeech(String usspeech) {
            this.usspeech = usspeech;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean {
        /**
         * value : ["人型机器人学"]
         * key : android science
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
