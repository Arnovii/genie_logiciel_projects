package model;

public class ModelTester {
    public static void main(String[] args) {
        CalculatorModel calc = new CalculatorModel();

        while(true) {
            String input = calc.listen();

            calc.process(input);
        }
    }
}