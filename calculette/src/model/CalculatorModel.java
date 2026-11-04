package model;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {

    public Stack<Double> myStack;


    /*
    Constructor.
    */
    public CalculatorModel() {
        this.myStack = new Stack<>();
    }


    /*
    Returns the current state of the stack.
    */
    public Stack getStack() {
        return this.myStack;
    }


    /*
    Adds the 2 numbers on top of the stack, pops them and pushes the result.
    */
    public void add() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x + y);
    }

    /*
    Substract the second upmost number from the top of the stack, pops them and pushes the result.
    */
    public void substract() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x - y);
    }
    
    /*
    Multiply seed 1 and seed 2, pops them and pushes the result.
    */
    public void multiply() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x * y);
    }

    /*
    Divides seed 1 by seed 2, pops both and pushes the result.
    */
    public void divide() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x / y);
    }

    /*
    Turns seed 1 into -(seed 1).
    */
    public void opposite() {
        Double x = this.myStack.pop();
        
        this.myStack.push(-x);
    }

    /*
    Pops seed 1. 
    */
    public Double pop() {
        Double x = this.myStack.pop();
 
        return x;
    }
    

    /*
    Drops the top of the pile but doesn't.
    */
    public void drop() {
        this.myStack.pop();
    }

    /*
    Swaps seed 1 and seed 2.
    */
    public void swap() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x);
        this.myStack.push(y);
    }

    /*
    Clears the stack.
    */
    public void clear() {
        this.myStack = new Stack<>();
    }
}