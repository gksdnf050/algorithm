package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());

        Tree root = new Tree();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            root.create(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        root.preOrder(root.root);
        System.out.println();
        root.inOrder(root.root);
        System.out.println();
        root.postOrder(root.root);

    }


}
class Tree {
    Node root;

    public void create(char value, char left, char right) {
        if(root == null) {
            if(value != '.') root = new Node(value);
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        }

        else search(root, value, left, right);

    }

    public void search(Node root, char value, char left, char right) {
        if(root == null) return;

        if(root.value == value) {
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        } else {
            search(root.left, value, left, right);
            search(root.right, value, left, right);
        }
    }

    public void preOrder(Node root) {
        System.out.print(root.value);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root.left != null) inOrder(root.left);
        System.out.print(root.value);
        if(root.right != null) inOrder(root.right);
    }
    public void postOrder(Node root) {
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.print(root.value);
    }


}

class Node {
    Node left;
    Node right;
    char value;

    Node(char value) {
        this.value = value;
    }


}
