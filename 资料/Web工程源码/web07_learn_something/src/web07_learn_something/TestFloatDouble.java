package web07_learn_something;

import java.math.BigDecimal;

public class TestFloatDouble {
	public static void main(String[] args) {
//		double a = 1;
//		double b = 5;
//		double res = a+b;
//		System.out.println(res);
		
		float fa = 0.01f;
		float fb = 0.05f;
//		float res = a+b;
//		System.err.println(a+b);

		BigDecimal a = new BigDecimal(Float.toString(fa));
		BigDecimal b = new BigDecimal(Float.toString(fb));
		BigDecimal res = a.add(b);
		System.out.println(res);
		System.out.println(res.floatValue());
		System.out.println(res.doubleValue());
	}
}
