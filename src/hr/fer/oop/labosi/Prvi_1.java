package hr.fer.oop.labosi;

import java.util.Scanner;

public class Prvi_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string, najduzi = "";

         while (!(string = sc.nextLine()).equals("KRAJ")) {
            if (string.length() > najduzi.length()) najduzi = string;
         }

         System.out.println(najduzi);
    }
}
