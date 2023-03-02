package com.ll;

import java.util.HashMap;
import java.util.Map;


//Request
public class Rq {
    private String actionCode;
    private Map<String, String> params;


    public Rq(String input){
        String[] inputBits = input.split("\\?", 2); // ?를 기준으로 2개까지만 나눔

        actionCode = inputBits[1];
        params = new HashMap<>();
        String[] paramBits = inputBits[1].split("&");

        if(inputBits.length==1) return;

        for(String paramStr : paramBits){
            String[] paramStrBits = paramStr.split("=",2);

            if(paramBits.length==1) continue;

            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key,value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }
}

