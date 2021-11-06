package hr.fer.oop.work;

public class RandomAndArrays {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Potreban je argument dužine polja");
            System.exit(1);
        }

        int velicina_polja = Integer.parseInt(args[0]);
        int[] polje = new int[velicina_polja];

        for (int i = 0; i < velicina_polja; i++) {
            polje[i] = (int)(Math.random() * 100);
        }

        for (int i = polje.length -1; i >= 0; i--) {
            System.out.println("Array[" + i + "] = " + polje[i]);
        }
        int largestInt = polje[0];
        int smallestInt = polje[0];

        int indexOfLargest = 0;
        int indexOfSmallest = 0;

        for (int i = 0; i < polje.length; i++) {
            if(polje[i] > largestInt){
                largestInt = polje[i];
                indexOfLargest = i;
            }
            if(polje[i] < smallestInt){
                smallestInt = polje[i];
                indexOfSmallest = i;
            }
        }
        System.out.println();
        System.out.println("Smallest integer in array is: " + smallestInt + " at position ["
                + indexOfSmallest + "]" );
        System.out.println("Largest integer in array is: " + largestInt + " at position [" +
                indexOfLargest + "]" );
    }

}


