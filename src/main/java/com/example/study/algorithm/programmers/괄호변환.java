package com.example.study.algorithm.programmers;

public class 괄호변환 {
    public String solution(String p) {
        String answer = "";
        answer = convert(p);
        return answer;
    }

    public String convert(String p) {
        if (p.equals("")) return p;

        int open = 0;
        int close = 0;
        String u = "";
        String v = "";
        int i;
        for (i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') open++;
            if (p.charAt(i) == ')') close++;

            u += p.charAt(i);
            if (open == close) break;
        }

        v = p.substring(i + 1, p.length());
        if (check(u)) return u + convert(v);
        else {
            String temp = "(" + convert(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", "t").replace(")", "(").replace("t", ")");
            temp += u;
            return temp;
        }
    }

    public boolean check(String str) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') open++;
            if (str.charAt(i) == ')') close++;

            if (close > open) return false;
        }

        if (close != open) return false;

        return true;
    }
}
