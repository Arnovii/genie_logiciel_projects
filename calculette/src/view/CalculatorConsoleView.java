package view;

import java.util.List;

/**
 * Text view of the calculator: prints the accumulator and the stack in the terminal.
 * Used to test the model without the graphical interface.
 */
public class CalculatorConsoleView implements CalculatorViewInterface {

    @Override
    public void affiche() {
        System.out.println("=== RPN Calculator ===");
    }

    @Override
    public void change(String accu) {
        boolean empty = (accu == null || accu.isEmpty());
        System.out.println("accu  : " + (empty ? "0.0" : accu));
    }

    @Override
    public void change(List<Double> stackData) {
        System.out.println("stack : " + stackData);
    }
}
