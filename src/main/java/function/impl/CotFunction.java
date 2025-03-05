package function.impl;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CotFunction implements Function {

    private final Function sin;
    private final Function cos;

    @Override
    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new IllegalArgumentException("no NaN or Infinity here!");

        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        if (normalizedX == 0 || normalizedX == Math.PI)
            throw new ArithmeticException("cot is not defined for 0 and PI");

        return cos.calculate(normalizedX, epsilon) / sin.calculate(normalizedX, epsilon);
    }
}
