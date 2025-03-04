package function.impl;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CscFunction implements Function {

    private final Function sin;

    @Override
    public double calculate(double x, double epsilon) {
        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        if (normalizedX == 0 || normalizedX == Math.PI)
            throw new ArithmeticException("csc is not defined for 0 and PI");

        return 1 / sin.calculate(normalizedX, epsilon);
    }
}
