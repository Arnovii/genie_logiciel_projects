package controller;

import java.util.List;

/**
 * What the controller offers to the model and to the view.
 * The model calls the two change methods; the view calls onButton.
 */
public interface CalculatorControllerInterface {

    /**
     * Called by the model when the accumulator changes.
     *
     * @param accu the new accumulator ("" means empty)
     */
    void change(String accu);

    /**
     * Called by the model when the stack changes.
     *
     * @param stackData the stack values, from bottom to top
     */
    void change(List<Double> stackData);

    /**
     * Called by the view when the user presses a key.
     *
     * @param key the label of the key: "0"-"9", ",", "+", "-", "*", "/", "+/-",
     *            "<>", "pop", "drop", "swap", "clear" or "dropAll"
     */
    void onButton(String key);
}
