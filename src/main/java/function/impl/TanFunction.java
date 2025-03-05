package function.impl;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TanFunction implements Function {

    private final Function sin;
    private final Function cos;

    @Override
    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new IllegalArgumentException("no NaN or Infinity here!");

        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        if (normalizedX == Math.PI / 2 || normalizedX == Math.PI * 3 / 2)
            throw new ArithmeticException("tan is not defined for PI/2 and 3*PI/2");

        return sin.calculate(x, epsilon) / cos.calculate(x, epsilon);
    }
}
