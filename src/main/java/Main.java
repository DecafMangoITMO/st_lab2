import function.Function;
import function.impl.CscFunction;
import function.impl.SinFunction;
import util.CalculationRecorder;

public class Main {

    public static void main(String[] args) {
        Function function = new CscFunction(new SinFunction());

        CalculationRecorder.record(function, 0, Double.MIN_VALUE, Math.PI / 2, 10, "./log.csv");
    }

}
