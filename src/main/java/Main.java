import function.Function;
import function.impl.CosFunction;
import function.impl.Log10Function;
import function.impl.LogEFunction;
import function.impl.SinFunction;

public class Main {

    public static void main(String[] args) {
        Function f = new CosFunction(new SinFunction());
        Function f2 = new Log10Function(new LogEFunction());

        System.out.println(f2.calculate(10, 10e-5));
    }

}
