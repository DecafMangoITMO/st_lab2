package util;

import function.Function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CalculationRecorder {

    public static void record(Function function, double x, double epsilon, double step, int stepCount, String filepath) {
        if (function == null)
            throw new NullPointerException("function is null");
        if (step <= 0)
            throw new IllegalArgumentException("step <= 0");
        if (stepCount <= 0)
            throw new IllegalArgumentException("stepCount <= 0");
        if (filepath == null)
            throw new NullPointerException("filepath is null");
        if (!filepath.endsWith(".csv")) {
            throw new IllegalArgumentException("File must have an extension: .csv");
        }

        File file = new File(filepath);
        if (!file.exists()) {
            try {
                if (!file.createNewFile())
                    throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Failure during file creation: " + filepath);
                return;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("X:Result\n");

            double y;
            for (int i = 0; i < stepCount; i++) {
                try {
                    y = function.calculate(x, epsilon);
                    bw.write(String.format("%f:%f\n", x, y));
                } catch (ArithmeticException e) {
                    bw.write(String.format("%f:%s\n", x, e.getMessage()));
                } finally {
                    x += step;
                }
            }
        } catch (Exception e) {
            System.out.println("failure during writing file: " + filepath);
            return;
        }

        System.out.println("Record completed");
    }


}
