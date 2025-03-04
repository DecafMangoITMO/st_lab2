import function.Function;
import function.impl.*;

public class Main {

    public static void main(String[] args) {
        Function f = new CscFunction(new SinFunction());

        System.out.println(f.calculate(1, 0.000001));
    }

}
