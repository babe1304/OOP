package hr.fer.oop.work;

public class DigitCompare {

    public static void main(String[] args) {
        System.out.println(common_digit(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }

    static boolean common_digit(int twoDigitNum1, int twoDigitNum2) {
        String prvi = String.valueOf(twoDigitNum1);
        String drugi = String.valueOf(twoDigitNum2);

        char[] znamenke1 = prvi.toCharArray();
        char[] znamenke2 = drugi.toCharArray();

        if (znamenke1.length < 2 || znamenke2.length < 2) return false;

        return (znamenke1[0] == znamenke2[0] || znamenke1[0] == znamenke2[1] || znamenke1[1] == znamenke2[0] || znamenke1[1] == znamenke2[1]);
    }

}
