package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    String fileName = scan.nextLine();
    scan.close();
    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
    StringBuilder builder =  new StringBuilder();
        while(fileReader.ready()){
            builder.append(fileReader.readLine()+" ");
        }
        fileReader.close();
        String[] array = builder.toString().trim().split(" ");
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if (set.contains(i)) continue;
            for(int j = i+1; j < array.length; j++){
                String buff = new StringBuilder(array[j]).reverse().toString();
                if (buff.equals(array[i])){
                    Pair p = new Pair();
                    p.first = array[i];
                    p.second = buff;
                    set.add(j);
                    result.add(p);
                    break;
                }
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
