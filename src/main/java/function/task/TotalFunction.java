package function.task;

import function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TotalFunction implements Function {

    private final Function trigFunction;
    private final Function logFunction;

    @Override
    public double calculate(double x, double epsilon) {
        if (epsilon <= 0)
            throw new ArithmeticException("epsilon must be positive");

        if (x <= 0)
            return trigFunction.calculate(x, epsilon);
        else
            return logFunction.calculate(x, epsilon);
    }
}
