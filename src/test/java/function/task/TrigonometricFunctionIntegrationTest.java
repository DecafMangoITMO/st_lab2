package function.task;

import function.Function;
import function.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class TrigonometricFunctionIntegrationTest {

    private static final double EPSILON = Double.MIN_VALUE;
    private static final int TO_ROUND = 5;
    private static final double DELTA = Math.pow(10, -TO_ROUND);

    private static Function sin;
    private static Function cos;
    private static Function tan;
    private static Function cot;
    private static Function sec;
    private static Function csc;

    private static Function trigFunction;

    @BeforeAll
    public static void init() {
        sin = Mockito.mock(SinFunction.class);
        cos = Mockito.mock(CosFunction.class);
        tan = Mockito.mock(TanFunction.class);
        cot = Mockito.mock(CotFunction.class);
        sec = Mockito.mock(SecFunction.class);
        csc = Mockito.mock(CscFunction.class);

        trigFunction = new TrigonometricFunction(sin, cos, tan, cot, sec, csc);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-5.8485:-6.51712",
            "-4.777:-2.12107",
            "-2.505:3.88417",
            "-0.97203:0"
    }, delimiter = ':')
    public void testNormalNonPositivePoints(double x, double yExpected) {
        Mockito.when(sin.calculate(x, EPSILON)).thenReturn(Math.sin(x));
        Mockito.when(cos.calculate(x, EPSILON)).thenReturn(Math.cos(x));
        Mockito.when(tan.calculate(x, EPSILON)).thenReturn(Math.tan(x));
        Mockito.when(cot.calculate(x, EPSILON)).thenReturn(1 / Math.tan(x));
        Mockito.when(sec.calculate(x, EPSILON)).thenReturn(1 / Math.cos(x));
        Mockito.when(csc.calculate(x, EPSILON)).thenReturn(1 / Math.sin(x));

        double yCalculated = trigFunction.calculate(x, EPSILON);

        Assertions.assertEquals(yExpected, yCalculated, DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -5.8485d,
            -4.777d,
            -2.626d,
            -1.34d
    })
    public void testPeriod(double x) {
        Mockito.when(sin.calculate(x, EPSILON)).thenReturn(Math.sin(x));
        Mockito.when(sin.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(Math.sin(x));

        Mockito.when(cos.calculate(x, EPSILON)).thenReturn(Math.cos(x));
        Mockito.when(cos.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(Math.cos(x));

        Mockito.when(tan.calculate(x, EPSILON)).thenReturn(Math.tan(x));
        Mockito.when(tan.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(Math.tan(x));

        Mockito.when(cot.calculate(x, EPSILON)).thenReturn(1 / Math.tan(x));
        Mockito.when(cot.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(1 / Math.tan(x));

        Mockito.when(sec.calculate(x, EPSILON)).thenReturn(1 / Math.cos(x));
        Mockito.when(sec.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(1 / Math.cos(x));

        Mockito.when(csc.calculate(x, EPSILON)).thenReturn(1 / Math.sin(x));
        Mockito.when(csc.calculate(x - 2 * Math.PI, EPSILON)).thenReturn(1 / Math.sin(x));

        double yCalculated1 = trigFunction.calculate(x, EPSILON);
        double yCalculated2 = trigFunction.calculate(x - 2 * Math.PI, EPSILON);

        Assertions.assertEquals(yCalculated1, yCalculated2, EPSILON);
    }

}
