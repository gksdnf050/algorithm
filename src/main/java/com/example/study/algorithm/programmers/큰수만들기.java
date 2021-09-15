package com.example.study.algorithm.programmers;

public class 큰수만들기 {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int count = number.length() - k;
        int size = number.length() - count;
        int index = 0;
        int j = 0;

        while (count > 0) {
            int max = -1;
            for (int i = j; i <= size; i++) {
                if (number.charAt(i) - '0' > max) {
                    max = number.charAt(i) - '0';
                    index = i;
                }
            }

            sb.append(number.charAt(index));
            j = index + 1;
            count -= 1;
            size = number.length() - count;
        }

        return sb.toString();
    }
}
