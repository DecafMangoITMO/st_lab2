package function.impl;

import function.Function;

public class LogEFunction implements Function {

    @Override
    public double calculate(double y, double epsilon) {
        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        if (y <= 0) {
            throw new ArithmeticException("x must be greater than 0");
        }

        int k = 0;
        while (y >= 2) {
            y /= 2;
            k++;
        }
        while (y < 1) {
            y *= 2;
            k--;
        }

        double x = y - 1;
        double result = 0;
        double term = x;
        int n = 1;

        while (Math.abs(term) > epsilon) {
            result += term;
            n++;
            term = Math.pow(-1, n + 1) * Math.pow(x, n) / n;
        }

        return result + k * Math.log(2);
    }
}
