package function.task;

import function.Function;
import function.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TotalFunctionUnitTest {

    private static final double EPSILON = Double.MIN_VALUE;
    private static final double DELTA = 10e-5d;

    private static Function sin;
    private static Function cos;
    private static Function tan;
    private static Function cot;
    private static Function sec;
    private static Function csc;

    private static Function trigFunction;

    private static Function ln;
    private static Function log2;
    private static Function log3;
    private static Function log10;

    private static Function logFunction;

    private static Function totalFunction;

    @BeforeAll
    public static void init() {
        sin = new SinFunction();
        cos = new CosFunction(sin);
        tan = new TanFunction(sin, cos);
        cot = new CotFunction(sin, cos);
        sec = new SecFunction(cos);
        csc = new CscFunction(sin);

        trigFunction = new TrigonometricFunction(sin, cos, tan, cot, sec, csc);

        ln = new LogEFunction();
        log2 = new Log2Function(ln);
        log3 = new Log3Function(ln);
        log10 = new Log10Function(ln);

        logFunction = new LogarithmicFunction(ln, log2, log3, log10);

        totalFunction = new TotalFunction(trigFunction, logFunction);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-5.8485:-6.51712",
            "-5.764:-5.01322",
            "-5.63:-3.77661"
    }, delimiter = ':')
    public void testFirstIntervalNonPositiveX(double x, double yExpected) {
        double yCalculated = totalFunction.calculate(x, EPSILON);

        Assertions.assertEquals(yExpected, yCalculated, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-4.777:-2.12107",
            "-4.615:-1.78571",
            "-4.11362:0"
    }, delimiter = ':')
    public void testSecondIntervalNonPositiveX(double x, double yExpected) {
        double yCalculated = totalFunction.calculate(x, EPSILON);

        Assertions.assertEquals(yExpected, yCalculated, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2.626:5.06171",
            "-2.505:3.88417",
            "-2.345:3.14729"
    }, delimiter = ':')
    public void testThirdIntervalNonPositiveX(double x, double yExpected) {
        double yCalculated = totalFunction.calculate(x, EPSILON);

        Assertions.assertEquals(yExpected, yCalculated, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1.34:1.42589",
            "-1.018:0.21748",
            "-0.97203:0"
    }, delimiter = ':')
    public void testFourthIntervalNonPositiveX(double x, double yExpected) {
        double yCalculated = totalFunction.calculate(x, EPSILON);

        Assertions.assertEquals(yExpected, yCalculated, DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -2 * Math.PI,
            -3 * Math.PI / 2,
            -Math.PI,
            -Math.PI / 2,
            0
    })
    public void testSpecialNonPositivePoints(double x) {
        Assertions.assertThrows(ArithmeticException.class, () -> { totalFunction.calculate(x, EPSILON);});
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -5.8485d,
            -4.777d,
            -2.626d,
            -1.34d
    })
    public void testPeriodNonPositivePoints(double x) {
        double yCalculated1 = totalFunction.calculate(x, EPSILON);
        double yCalculated2 = totalFunction.calculate(x - 2 * Math.PI, EPSILON);

        Assertions.assertEquals(yCalculated1, yCalculated2, DELTA);
    }
}
