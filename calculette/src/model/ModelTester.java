package model;

import java.util.Scanner;

public class ModelTester {
    public static void main(String[] args) {
        CalculatorModel calc = new CalculatorModel();

        while(true) {
            String input = listen(calc);

            process(calc, input);
        }
    }

    /*
    Displays current state of the stack, ask for an input, returns the String input. This is bound to be deleted.
    */
    public static String listen(CalculatorModel calc) {
        System.out.println(calc.myStack);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }

    /*
    Checks what type of entry was used, in case of a number, converts it to Double, and processes the relevant method.
    */
    public static void process(CalculatorModel calc, String input) {

        try {
            calc.myStack.push(Double.parseDouble(input));
        }   catch (Exception e) {
            
                switch (input) {
                    case "+"        -> calc.add();
                    case "-"        -> calc.substract();
                    case "*"        -> calc.multiply();
                    case "/"        -> calc.divide();
                    case "(-)"      -> calc.opposite();
                    case "pop"      -> calc.pop();
                    case "drop"     -> calc.drop();
                    case "swap"     -> calc.swap();
                    case "clear"    -> calc.clear();
                    default         -> listen(calc);
            }
        }
    }
}