package model;
import java.util.Scanner; // bound to be deleted
import java.util.Stack;

public class CalculatorModel {

    public Stack<Double> myStack;


    /*
    Constructor.
    */
    public CalculatorModel() {
        this.myStack = new Stack<>();
    }


    /*
    Displays current state of the stack, ask for an input, returns the String input. This is bound to be deleted.
    */
    public String listen() {
        System.out.println(this.myStack);

        Scanner scanner = new Scanner(System.in);
        String accu = scanner.nextLine();

        return accu;
    }

    /*
    Checks what type of entry was used, in case of a number, converts it to Double, and processes the relevant method.
    */
    public void process(String input) {
        switch (input) {
            case "+"        -> this.add();
            case "-"        -> this.substract();
            case "*"        -> this.multiply();
            case "/"        -> this.divide();
            case "(-)"      -> this.opposite();
            case "pop"      -> this.pop();
            case "drop"     -> this.drop();
            case "swap"     -> this.swap();
            case "clear"    -> this.clear();
            default         -> this.myStack.push(Double.parseDouble(input));
        }
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
    private void add() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x + y);
    }

    /*
    Substract the second upmost number from the top of the stack, pops them and pushes the result.
    */
    private void substract() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x - y);
    }
    
    /*
    Multiply seed 1 and seed 2, pops them and pushes the result.
    */
    private void multiply() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x * y);
    }

    /*
    Divides seed 1 by seed 2, pops both and pushes the result.
    */
    private void divide() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x / y);
    }

    /*
    Turns seed 1 into -(seed 1).
    */
    private void opposite() {
        Double x = this.myStack.pop();
        
        this.myStack.push(-x);
    }

    /*
    Pops seed 1. 
    */
    private Double pop() {
        Double x = this.myStack.pop();
 
        return x;
    }
    

    /*
    Drops the top of the pile but doesn't.
    */
    private void drop() {
        this.myStack.pop();
    }

    /*
    Swaps seed 1 and seed 2.
    */
    private void swap() {
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x);
        this.myStack.push(y);
    }

    /*
    Clears the stack.
    */
    private void clear() {
        this.myStack = new Stack<>();
    }
}