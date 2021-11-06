package hr.fer.oop.work;

public class Vector3D extends Triple<Number> {

    public Vector3D(Number a, Number b, Number c) {
        super(a, b, c);
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        return  v1.getElement(1).doubleValue() * v2.getElement(1).doubleValue() + v1.getElement(2).doubleValue() * v2.getElement(2).doubleValue() + v1.getElement(3).doubleValue() * v2.getElement(3).doubleValue();
    }
}
