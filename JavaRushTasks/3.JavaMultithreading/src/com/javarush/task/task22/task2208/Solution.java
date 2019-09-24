package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        if(params == null || params.isEmpty()){
            return builder.toString();
        }
        for (Map.Entry<String, String> map : params.entrySet()){
            if(map.getKey() == null || map.getValue() == null){
                continue;
            }
            builder.append(map.getKey() + " = '" + map.getValue() + "' and ");
        }
        if (builder.length() > 5){
            builder.delete(builder.length() - 5, builder.length());
        }
        return builder.toString();
    }
}
