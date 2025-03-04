package function.impl;

import function.Function;

public class CosFunction implements Function {

    private final Function sin;

    public CosFunction(Function sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double epsilon) {
        double normalizedX = (x % (2 * Math.PI) + 2 * Math.PI) % (2 * Math.PI);

        double sinX = sin.calculate(normalizedX, epsilon);
        double cosX = Math.sqrt(Math.abs(1 - sinX * sinX));

        if (normalizedX > Math.PI / 2 && normalizedX < Math.PI * 3 / 2) {
            cosX = -cosX;
        }

        return cosX;
    }
}
