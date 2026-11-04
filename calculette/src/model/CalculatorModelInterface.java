// ===== src/model/CalculatorModelInterface.java ===== 

package model;

import java.util.Stack;

public interface CalculatorModelInterface {
    /*
    For inputs : "+", "-", "*", "/" will trigger relevant operations.
    Any number will push to the top of the stack.
    "(-)"" will swap the sign of the top of the stack.
    "drop" will delete the top of the stack.
    "swap" will swap the order between seeds 1 and 2.
    "clear" will clear the stack.
    Will return the current state of the Stack.
    */
    void process(String input);

    /*
    Gets the current state of the stack.
    */
    Stack<Double> getStack();
    }