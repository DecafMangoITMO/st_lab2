package function.impl;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TanFunction implements Function {

    private final Function sin;
    private final Function cos;

    @Override
    public double calculate(double x, double epsilon) {
        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        if (normalizedX == Math.PI / 2 || normalizedX == Math.PI * 3 / 2)
            throw new ArithmeticException("tan is not defined for PI/2 and 3*PI/2");

        return sin.calculate(x, epsilon) / cos.calculate(x, epsilon);
    }
}
