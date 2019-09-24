package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(reader.readLine());
        }
        reader.close();
        for(int j = 0; j < M; j++){
            String buff = list.get(0);
            list.add(buff);
            list.remove(0);
        }
        for(String str : list){
            System.out.println(str);
        }
        //напишите тут ваш код
    }
}
