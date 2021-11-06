package hr.fer.oop.util;

public class GCD {
	
	public static int gcd(int prvi, int drugi) {
		return (drugi == 0) ? prvi : gcd(drugi, prvi % drugi);
	}
}
