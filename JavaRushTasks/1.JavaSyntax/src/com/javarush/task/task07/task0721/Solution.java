package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] massive = new int [20];

        for(int i = 0; i < massive.length; i++){
            massive[i] = Integer.parseInt(reader.readLine());
        }
        int maximum = massive[0];
        int minimum = massive[0];
        for(int i : massive){
            if(maximum < i){
                maximum = i;
            }
            if(minimum > i){
                minimum = i;
            }
        }
        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
