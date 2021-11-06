package hr.fer.oop.work;

public class KvadratnaJednadzba {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Program needs arguments for a, b, and c in ax^2 + bx = c");
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        double det = Math.pow(b, 2) - 4 * a * c;
        if (det < 0) {
            System.out.println("No solution available in R");
        } else {
            double rez1 = (-b + Math.sqrt(det)) / (2*a);
            double rez2 = (-b - Math.sqrt(det)) / (2*a);

            System.out.printf("Solutions are: \nx1 = %.2f \nx2 = %.2f", rez1, rez2);
        }
    }

}
