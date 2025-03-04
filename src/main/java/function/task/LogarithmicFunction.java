package function.task;

import function.Function;
import function.impl.*;

public class LogarithmicFunction implements Function {

    @Override
    public double calculate(double x, double epsilon) {
        Function ln = new LogEFunction();
        Function log_2 = new Log2Function(ln);
        Function log_3 = new Log3Function(ln);
        Function log_10 = new Log10Function(ln);

        if ((x <= 0) || (x == 1)) {
            throw new ArithmeticException("x must be greater than 0 and not equal to 1");
        }

        return ((Math.pow(((Math.pow((log_2.calculate(x, epsilon) + ln.calculate(x, epsilon)), 3)) / log_3.calculate(x, epsilon)), 3)) * (log_10.calculate(x, epsilon) - ln.calculate(x, epsilon)));
    }
}
