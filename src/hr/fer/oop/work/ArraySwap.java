package hr.fer.oop.work;

import java.lang.Math;

public class ArraySwap {

    public static void main(String[] args) {
        int[] arr = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])};
        ArraySwap.swap(arr);
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
    }

    static void swap(int[] arr) {
        int duljina = arr.length;
        int a = (int) (Math.random() * duljina);
        int b = (int) (Math.random() * duljina);
        int c = (int) (Math.random() * duljina);
        int zamjena;

        if (a > b) {
            if (c > a) {
                zamjena = arr[b];
                arr[b] = arr[a];
                arr[a] = arr[c];
                arr[c] = zamjena;
            } else {
                if (c > b) {
                    zamjena = arr[b];
                    arr[b] = arr[c];
                    arr[c] = arr[a];
                    arr[a] = zamjena;
                } else {
                    zamjena = arr[c];
                    arr[c] = arr[b];
                    arr[b] = arr[a];
                    arr[a] = zamjena;
                }
            }
        } else {
            if (c > b) {
                zamjena = arr[a];
                arr[a] = arr[b];
                arr[b] = arr[c];
                arr[c] = zamjena;
            } else {
                if (c > a) {
                    zamjena = arr[a];
                    arr[a] = arr[c];
                    arr[c] = arr[b];
                    arr[b] = zamjena;
                } else {
                    zamjena = arr[c];
                    arr[c] = arr[a];
                    arr[a] = arr[b];
                    arr[b] = zamjena;
                }
            }
        }
    }
}
