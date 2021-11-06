package hr.fer.oop.work;

import java.lang.Math;

public class Pi {
    public static void main(String[] args) {
        System.out.println(racunajPi(10));
        System.out.println(racunajPi(100));
        System.out.println(racunajPi(1000));
        System.out.println(racunajPi(10000));
        System.out.println("==================");
        System.out.println(racunajPi2(10));
        System.out.println(racunajPi2(100));
        System.out.println(racunajPi2(1000));
        System.out.println(racunajPi2(10000));
        System.out.println("==================");
        vratiBroj();
    }

    public static double racunajPi(int n) {
        double rez = 0.d;
        for (int i = 0; i < n; i++) {
            rez += Math.pow(-1, i) / (2*i +1);
        }
        return rez*4;
    }

    public static double racunajPi2(int n) {
        double rez = 0.d;
        for (int i = 1; i < (n + 1); i++) {
            rez += 1 / Math.pow(i, 2);
        }
        rez *= 6;
        return Math.sqrt(rez);
    }

    public static void vratiBroj() {
        double sum = 0;
        int first5 = (int) (Math.PI * 1e5);
        int calc5 = 0;
        int i = 0;
        while (first5 != calc5) {
            ++i;
            sum += 1. / ((double) i * i);
            calc5 = (int) (1e5 * Math.sqrt(6 * sum));
        }
        System.out.printf("Pi after %d steps is %f%n", i, Math.sqrt(6. * sum));
    }
}
