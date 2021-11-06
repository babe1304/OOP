package hr.fer.oop.labosi;


public class Prvi_2 {

    public static void main(String[] args) {
        int[] arr = new int[9];
        Prvi_2.deacreasing(arr);

        for (int broj: arr) {
            System.out.println(broj);
        }
    }

    public static void deacreasing(int[] arr) {
        int donja_granica = (int) (Math.random() * 50000) + 50000;

        for (int i = 0; i < arr.length; i++) {
            if (donja_granica <= 1) {
                arr[i] = 0;
            } else {
                arr[i] = donja_granica;
                donja_granica = (int) (Math.random() * (donja_granica / 2)) + (donja_granica / 2);
            }
        }
    }

}
