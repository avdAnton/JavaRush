package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.ArrayList;

import static java.util.Collections.max;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countOfNum = Integer.parseInt(reader.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < countOfNum; i++){
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        int maximum = numbers.get(0);

        for (Integer list : numbers){
            if (list >= maximum) {
                maximum = list;
            }
        }
        System.out.println(maximum);


    }

}
