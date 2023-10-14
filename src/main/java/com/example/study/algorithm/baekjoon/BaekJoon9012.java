package com.example.study.algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            String str = sc.next();
            check(str);
        }


    }

    private static void check(String str) {
        if(str.charAt(0) == ')') {
            System.out.println("NO");
            return;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
               stack.push(c);
           }

           if(c == ')') {
               if(stack.size() == 0) {
                   System.out.println("NO");
                   return;
               } else {
                   stack.pop();
               }
           }
        }

        if(stack.size() == 0) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

}