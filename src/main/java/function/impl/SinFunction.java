package function.impl;

import function.Function;

public class SinFunction implements Function {

    @Override
    public double calculate(double x, double epsilon) {
        double sum = 0.0;
        double term = x;
        int n = 1;

        while (Math.abs(term) >= epsilon) {
            sum += term;
            term = -term * x * x / ((2 * n) * (2 * n + 1));
            n++;
        }

        return sum;
    }

}
