package function.task;

import function.Function;
import function.impl.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrigonometricFunction implements Function {

    private final Function sin;
    private final Function cos;
    private final Function tan;
    private final Function cot;
    private final Function sec;
    private final Function csc;

    @Override
    public double calculate(double x, double epsilon) {
        if (epsilon <= 0d)
            throw new IllegalArgumentException("epsilon must be positive");

        return (((((tan.calculate(x, epsilon) / sec.calculate(x, epsilon)) * cot.calculate(x, epsilon)) - sec.calculate(x, epsilon)) - csc.calculate(x, epsilon)) * ((csc.calculate(x, epsilon) + sin.calculate(x, epsilon)) / sec.calculate(x, epsilon)));
    }

}
