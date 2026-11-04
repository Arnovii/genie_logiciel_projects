// ===== src/model/CalculatorModelInterface.java ===== 

package model;

import java.util.Stack;

public interface CalculatorModelInterface {

    /*
    Gets the current state of the stack.
    */
    Stack<Double> getStack();

    /*
    Adds seeds 1 and 2, pops them and pushes the result.
    */
    void add();

    /*
    Substract seed 2 from seed 1, pops them and pushes the result.
    */
    void substract();

    /*
    Multiply seed 1 and seed 2, pops them and pushes the result.
    */
    void multiply();

    /*
    Divides seed 1 by seed 2, pops both and pushes the result.
    */
    void divide();

    /*
    Turns seed 1 into -(seed 1).
    */
    void opposite();

    /*
    Pops seed 1. 
    */
    Double pop();

    /*
    Drops the top of the pile but doesn't.
    */
    void drop();

    /*
    Swaps seed 1 and seed 2.
    */
    void swap();

    /*
    Clears the stack.
    */
    void clear();
    }