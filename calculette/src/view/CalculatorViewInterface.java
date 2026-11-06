package view;

import java.util.List;

/**
 * What every view of the calculator (console or JavaFX) must be able to do.
 * The controller only knows this interface, so it can work with any view.
 */
public interface CalculatorViewInterface {

    /** Shows the view for the first time, with an empty calculator. */
    void affiche();

    /**
     * Shows a new value for the accumulator.
     *
     * @param accu the text to display ("" or null means empty)
     */
    void change(String accu);

    /**
     * Shows the new content of the stack.
     *
     * @param stackData the stack values, from bottom (index 0) to top (last index)
     */
    void change(List<Double> stackData);
}
