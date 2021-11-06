package hr.fer.oop.work;

public class Main {

    public static void main(String[] args) {
        double x = Vector3D.dotProduct(new Vector3D(-1,2,5), new Vector3D(4,-3,7));
        System.out.println(x);

        System.out.println(Utils.checkPassword("1234aBcd"));
    }
}
