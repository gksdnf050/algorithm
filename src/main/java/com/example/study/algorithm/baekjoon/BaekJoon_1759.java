package com.example.study.algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1759 {
    private int L;
    private int C;
    private String[] input;
    private String[] output;
    private boolean[] check;
    private List<String> vowels = Arrays.asList(
            "a", "e", "i", "o", "u"
    );

    public static void main(String[] args) throws IOException {
        BaekJoon_1759 bj = new BaekJoon_1759();
        bj.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        output = new String[L];
        input = new String[C];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            input[i] = st.nextToken();
        }

        Arrays.sort(input);

        find(0);
    }

    private void find(int depth) {
        if(depth == L) {
            if (possible()) {
                for (String str : output) {
                    System.out.print(str);
                }
                System.out.println();
            }
            return;
        }

        for(int i = 0; i < C; i++) {
            if(false == check[i] && checkOrder(depth, input[i])) {
                check[i] = true;
                output[depth] = input[i];
                find(depth + 1);
                check[i] = false;
            }
        }
    }

    private boolean checkOrder(int depth, String str) {
        if(0 == depth) {
            return true;
        }

        if(str.charAt(0) > output[depth - 1].charAt(0)) {
            return true;
        }

        return false;
    }

    private boolean possible() {
        int vowelCount = 0;
        int consonantCount = 0;
        for(String str : output) {
            if(isVowel(str)) {
                vowelCount++;
                continue;
            }

            consonantCount++;
        }

        if(1 <= vowelCount && 2 <= consonantCount) {
            return true;
        }

        return false;
    }

    private boolean isVowel(String str) {
        if(vowels.contains(str)) {
            return true;
        }

        return false;
    }
}
