import function.Function;
import function.task.LogarithmicFunction;

public class Main {

    public static void main(String[] args) {
        Function f = new LogarithmicFunction();
        System.out.println(f.calculate(5, Double.MIN_VALUE));
    }

}
