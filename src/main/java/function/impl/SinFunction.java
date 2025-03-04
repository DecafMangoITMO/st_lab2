package function.impl;

import function.Function;

public class SinFunction implements Function {

    @Override
    public double calculate(double x, double epsilon) {
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
