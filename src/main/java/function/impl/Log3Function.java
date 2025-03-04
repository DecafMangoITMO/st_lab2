package function.impl;

import function.Function;

public class Log3Function implements Function {

    private final Function ln;

    public Log3Function(Function ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (x <= 0) {
            throw new ArithmeticException("y must be greater than 0");
        }

        return ln.calculate(x, epsilon) / ln.calculate(3, epsilon);
    }

}
