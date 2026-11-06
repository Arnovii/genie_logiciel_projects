package model;

/**
 * Operations of the RPN calculator model.
 * The model holds an accumulator (the current number) and a stack (the memory).
 */
public interface CalculatorModelInterface {

    /**
     * Puts a typed number in the accumulator.
     *
     * @param value the number typed by the user
     */
    void setAccu(double value);

    /** Adds the two operands; the result goes to the accumulator. */
    void add();

    /** Subtracts the newest operand from the oldest one ("10 4 -" gives 6). */
    void substract();

    /** Multiplies the two operands; the result goes to the accumulator. */
    void multiply();

    /** Divides the oldest operand by the newest one ("10 4 /" gives 2.5). */
    void divide();

    /** Changes the sign of the operand. */
    void opposite();

    /** Moves the accumulator to the top of the stack. */
    void push();

    /** Moves the top of the stack to the accumulator. */
    void pop();

    /** Removes the top of the stack. */
    void drop();

    /** Swaps the two numbers on top of the stack. */
    void swap();

    /** Empties the accumulator. */
    void clear();

    /** Empties the stack. */
    void dropAll();
}
