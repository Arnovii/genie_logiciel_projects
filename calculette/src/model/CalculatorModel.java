package model;

import controller.CalculatorControllerInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Model of the RPN calculator: an accumulator and a stack.
 * Rules:
 * - an operation uses the accumulator (if it is full) as its newest operand,
 *   and takes the other operands from the stack;
 * - the result goes to the accumulator;
 * - if there are not enough operands, or for a division by 0, nothing changes;
 * - after every operation, the controller is notified (callback change).
 */
public class CalculatorModel implements CalculatorModelInterface {

    private Double accu = null;                           // null = empty accumulator
    private final Stack<Double> memory = new Stack<>();   // "memory" as in the UML diagram
    private CalculatorControllerInterface controller;     // who gets notified of changes

    /**
     * Sets the controller that will be notified after every change.
     *
     * @param controller the controller to notify
     */
    public void setController(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    /**
     * Puts a typed number in the accumulator.
     * If the accumulator already holds a result, that result is first pushed
     * on the stack so it is not lost (like an HP calculator).
     */
    @Override
    public void setAccu(double value) {
        if (accu != null) {
            memory.push(accu);
        }
        accu = value;
        notifyController();
    }

    @Override
    public void add() {
        binary('+');
    }

    @Override
    public void substract() {
        binary('-');
    }

    @Override
    public void multiply() {
        binary('*');
    }

    @Override
    public void divide() {
        binary('/');
    }

    @Override
    public void opposite() {
        if (accu != null) {
            accu = -accu;
        } else if (!memory.isEmpty()) {
            accu = -memory.pop();
        }
        notifyController();
    }

    @Override
    public void push() {
        if (accu != null) {
            memory.push(accu);
            accu = null;
        }
        notifyController();
    }

    @Override
    public void pop() {
        if (!memory.isEmpty()) {
            accu = memory.pop();
        }
        notifyController();
    }

    @Override
    public void drop() {
        if (!memory.isEmpty()) {
            memory.pop();
        }
        notifyController();
    }

    @Override
    public void swap() {
        if (memory.size() >= 2) {
            Collections.swap(memory, memory.size() - 1, memory.size() - 2);
        }
        notifyController();
    }

    @Override
    public void clear() {
        accu = null;
        notifyController();
    }

    @Override
    public void dropAll() {
        memory.clear();
        notifyController();
    }

    /**
     * Shared code of + - * /.
     * Newest operand b = the accumulator if full, otherwise the top of the stack.
     * Oldest operand a = the next number on the stack. Result = a op b.
     */
    private void binary(char operator) {
        int operands = memory.size() + (accu != null ? 1 : 0);
        if (operands < 2) {
            notifyController();                // not enough operands: nothing changes
            return;
        }
        double b = (accu != null) ? accu : memory.peek();
        if (operator == '/' && b == 0) {
            notifyController();                // division by 0: refused, nothing changes
            return;
        }
        if (accu == null) {
            memory.pop();                      // b came from the stack: remove it
        }
        double a = memory.pop();
        accu = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> a / b;
        };
        notifyController();
    }

    /** Sends the new accumulator and a copy of the stack to the controller. */
    private void notifyController() {
        if (controller == null) {
            return;
        }
        controller.change(accu == null ? "" : String.valueOf(accu));
        controller.change(new ArrayList<>(memory));
    }

    /**
     * Returns the accumulator (for tests).
     *
     * @return the accumulator, or null if it is empty
     */
    public Double getAccu() {
        return accu;
    }

    /**
     * Returns a copy of the stack, from bottom to top (for tests).
     *
     * @return a copy of the stack
     */
    public List<Double> getStack() {
        return new ArrayList<>(memory);
    }
}
