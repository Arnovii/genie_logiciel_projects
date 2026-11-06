package controller;

import java.util.List;
import model.CalculatorModelInterface;
import view.CalculatorViewInterface;

/**
 * Links the view and the model.
 * View to model: it turns each key into a model operation.
 * Model to view: the model calls change(...), and the controller forwards it to the view.
 * It also keeps the number being typed until it is sent to the accumulator.
 */
public class CalculatorController implements CalculatorControllerInterface {

    private final CalculatorModelInterface model;
    private final CalculatorViewInterface view;
    private final StringBuilder typing = new StringBuilder();   // number being typed, e.g. "12,5"

    /**
     * Creates the controller.
     *
     * @param model the calculator model
     * @param view  the view to keep up to date (console or JavaFX)
     */
    public CalculatorController(CalculatorModelInterface model, CalculatorViewInterface view) {
        this.model = model;
        this.view = view;
    }

    /** Called by the model: shows the new accumulator. */
    @Override
    public void change(String accu) {
        view.change(accu);
    }

    /** Called by the model: shows the new stack. */
    @Override
    public void change(List<Double> stackData) {
        view.change(stackData);
    }

    /**
     * Called by the view for each key.
     * Digits and the comma build the typed number; any other key first sends
     * the typed number to the accumulator, then runs the operation.
     */
    @Override
    public void onButton(String key) {
        if (key.matches("[0-9]")) {
            typing.append(key);
            view.change(typing.toString());
            return;
        }
        if (key.equals(",")) {
            addComma();
            view.change(typing.toString());
            return;
        }
        sendTypingToAccu();
        switch (key) {
            case "<>" -> model.push();
            case "+" -> model.add();
            case "-" -> model.substract();
            case "*" -> model.multiply();
            case "/" -> model.divide();
            case "+/-" -> model.opposite();
            case "pop" -> model.pop();
            case "drop" -> model.drop();
            case "swap" -> model.swap();
            case "clear" -> model.clear();
            case "dropAll" -> model.dropAll();
            default -> { }
        }
    }

    /** Adds one comma to the typed number (only one is allowed). */
    private void addComma() {
        if (typing.indexOf(",") >= 0) {
            return;
        }
        if (typing.length() == 0) {
            typing.append("0");
        }
        typing.append(",");
    }

    /** Converts the typed text to a number, puts it in the accumulator, then empties the text. */
    private void sendTypingToAccu() {
        if (typing.length() == 0) {
            return;
        }
        double value = Double.parseDouble(typing.toString().replace(',', '.'));   // "12,5" -> 12.5
        typing.setLength(0);
        model.setAccu(value);
    }
}
