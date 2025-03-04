package function;

import function.impl.CosFunction;
import function.impl.SinFunction;

public class Main {

    public static void main(String[] args) {
        Function f = new CosFunction(new SinFunction());

        System.out.println(f.calculate(Math.PI / 2, 0.000000001));
    }

}
