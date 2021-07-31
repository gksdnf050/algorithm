package com.example.study.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {

    public static void main(String[] args) throws IOException {
        System.out.print("배열의 크기:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        System.out.print("원소 입력:");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(arr, 0, arr.length - 1);
        System.out.print("정렬 후:");
        for(int a: arr) {
            System.out.print(a + " ");
        }

    }

    public static void sort(int arr[], int low, int high) {
        if(low >= high) return;

        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    public static int partition(int arr[], int low, int high) {
        int first = low;
        int last = high;
        int pivot = arr[low];
        while (first < last) {
            while (first < last && arr[last] > pivot) last--;
            while (first < last && arr[first] <= pivot) first++;

            swap(arr, first, last);
        }

        System.out.println(last == first);

        swap(arr, low, first);

        return first;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
