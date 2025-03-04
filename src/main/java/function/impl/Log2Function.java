package function.impl;

import function.Function;

public class Log2Function implements Function {

    private final Function ln;

    public Log2Function(Function ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        if (x <= 0) {
            throw new ArithmeticException("y must be greater than 0");
        }

        return ln.calculate(x, epsilon) / ln.calculate(2, epsilon);
    }

}
