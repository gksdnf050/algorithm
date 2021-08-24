package com.example.study.algorithm.programmers;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i] + "";
        }

        Arrays.sort(temp, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        if (temp[0].equals("0")) return "0";

        for (String str : temp) {
            answer += str;
        }

        return answer;
    }
}
