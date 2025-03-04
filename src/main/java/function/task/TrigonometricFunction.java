package function.task;

import function.Function;
import function.impl.*;

public class TrigonometricFunction implements Function {

    @Override
    public double calculate(double x, double epsilon) {
        Function sin = new SinFunction();
        Function cos = new CosFunction(sin);
        Function tan = new TanFunction(sin, cos);
        Function cot = new CotFunction(sin, cos);
        Function sec = new SecFunction(cos);
        Function csc = new CscFunction(sin);

        return (((((tan.calculate(x, epsilon) / sec.calculate(x, epsilon)) * cot.calculate(x, epsilon)) - sec.calculate(x, epsilon)) - csc.calculate(x, epsilon)) * ((csc.calculate(x, epsilon) + sin.calculate(x, epsilon)) / sec.calculate(x, epsilon)));
    }

}
