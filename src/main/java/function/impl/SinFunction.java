package function.impl;

import function.Function;

public class SinFunction implements Function {

    @Override
    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new IllegalArgumentException("no NaN or Infinity here!");

        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        double sum = 0.0;
        double term = normalizedX;
        int n = 1;

        while (Math.abs(term) >= epsilon) {
            sum += term;
            term = -term * normalizedX * normalizedX / ((2 * n) * (2 * n + 1));
            n++;
        }

        return sum;
    }

}
