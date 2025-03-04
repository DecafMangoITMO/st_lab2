package function.task;

import function.Function;
import function.impl.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogarithmicFunction implements Function {

    private final Function ln;
    private final Function log_2;
    private final Function log_3;
    private final Function log_10;

    @Override
    public double calculate(double x, double epsilon) {
        if ((x <= 0) || (x == 1)) {
            throw new ArithmeticException("x must be greater than 0 and not equal to 1");
        }

        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        return ((Math.pow(((Math.pow((log_2.calculate(x, epsilon) + ln.calculate(x, epsilon)), 3)) / log_3.calculate(x, epsilon)), 3)) * (log_10.calculate(x, epsilon) - ln.calculate(x, epsilon)));
    }
}
