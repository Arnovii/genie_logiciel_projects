package model;
import java.util.Stack;
import java.util.Scanner;

public class CalculatorModel {

    public Stack<Double> myStack;
    private String accu;


    /*
    Constructor.
    */
    public CalculatorModel() {
        this.myStack = new Stack<>();
        this.accu = "";
    }


    /*
    Displays current state of the stack, ask for an input, returns the String input.     
    */
    public String listen(){
        System.out.println(this.myStack);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }

    /*
    Checks what type of entry was used, in case of a number, converts it to Double, and processes the relevant method.
    */
    public void process(String input) {
        switch (input) {
            case "+":
                this.add();
                break;

            case "-":
                this.substract();
                break;

            case "*":
                this.multiply();
                break;
            
            case "/":
                this.divide();
                break;
            
            case "(-)":
                this.opposite();
                break;

            case "pop":
                this.pop();
                break;

            case "drop":
                this.drop();
                break;

            case "swap":
                this.swap();
                break;

            case "clear":
                this.clear();
                break;
            
            default:
                this.myStack.push(Double.parseDouble(input));
        }
    }

    /*
    Adds the 2 numbers on top of the stack, pops them and pushes the result.
    */
    private void add(){
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x + y);
    }

    /*
    Substract the second upmost number from the top of the stack, pops them and pushes the result.
    */
    private void substract(){
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x - y);
    }
    
    /*
    Multiply seed 1 and seed 2, pops them and pushes the result.
    */
    private void multiply(){
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x * y);
    }

    /*
    Divides seed 1 by seed 2, pops both and pushes the result.
    */
    private void divide(){
        Double x = this.myStack.pop();
        Double y = this.myStack.pop();

        this.myStack.push(x / y);
    }

    /*
    Turns seed 1 into -(seed 1).
    */
    private void opposite(){
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
    I have no idea what thats supposed to do. 
    */
    private void drop(){

    }

    /*
    Swaps seed 1 and seed 2.
    */
    private void swap(){

    }

    /*
    Clears the stack.
    */
    private void clear(){

    }
}