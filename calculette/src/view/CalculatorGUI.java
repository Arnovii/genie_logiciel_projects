package view;

import controller.CalculatorControllerInterface;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * JavaFX view of the calculator: a screen (4 stack lines + the accumulator) and a keypad.
 * It never computes anything: it shows what it receives and tells the controller
 * which key was pressed.
 */
public class CalculatorGUI extends Scene implements CalculatorViewInterface {

    private static final int STACK_ROWS = 4;        // number of stack values shown on screen
    private static final double KEY_WIDTH = 64;

    private final Label[] stackLabels = new Label[STACK_ROWS];
    private final Label accuLabel;
    private CalculatorControllerInterface controller;   // given later by App

    /** Builds the window: the screen on top, the keypad below. */
    public CalculatorGUI() {
        super(new VBox(5), 300, 420);                // Scene needs a root: a vertical box
        VBox root = (VBox) getRoot();
        root.setPadding(new Insets(10));

        // 1. Screen: 4 stack lines, then the accumulator line at the bottom
        for (int i = 0; i < STACK_ROWS; i++) {
            stackLabels[i] = createScreenLine();
            root.getChildren().add(stackLabels[i]);
        }
        accuLabel = createScreenLine();
        root.getChildren().add(accuLabel);

        // 2. Keypad: one line of code per keypad row (key, column, row)
        GridPane keypad = new GridPane();
        keypad.setHgap(5);
        keypad.setVgap(5);
        addKey(keypad, "7", 0, 0);  addKey(keypad, "8", 1, 0);   addKey(keypad, "9", 2, 0);     addKey(keypad, "/", 3, 0);
        addKey(keypad, "4", 0, 1);  addKey(keypad, "5", 1, 1);   addKey(keypad, "6", 2, 1);     addKey(keypad, "*", 3, 1);
        addKey(keypad, "1", 0, 2);  addKey(keypad, "2", 1, 2);   addKey(keypad, "3", 2, 2);     addKey(keypad, "-", 3, 2);
        addKey(keypad, "0", 0, 3);  addKey(keypad, ",", 1, 3);   addKey(keypad, "+/-", 2, 3);   addKey(keypad, "+", 3, 3);
        addKey(keypad, "<>", 0, 4); addKey(keypad, "pop", 1, 4); addKey(keypad, "drop", 2, 4);  addKey(keypad, "swap", 3, 4);
        addKey(keypad, "clear", 0, 5); addKey(keypad, "dropAll", 1, 5);
        root.getChildren().add(keypad);
    }

    /**
     * Connects the view to the controller, so key presses reach it.
     *
     * @param controller the controller that will receive the key presses
     */
    public void setController(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    @Override
    public void affiche() {
        for (Label line : stackLabels) {
            line.setText("");
        }
        accuLabel.setText("0.0");
    }

    @Override
    public void change(String accu) {
        boolean empty = (accu == null || accu.isEmpty());
        accuLabel.setText(empty ? "0.0" : accu);
    }

    /** The line just above the accumulator shows the top of the stack. */
    @Override
    public void change(List<Double> stackData) {
        for (int i = 0; i < STACK_ROWS; i++) {
            int index = stackData.size() - 1 - i;                  // i = 0 -> top of the stack
            String text = (index >= 0) ? String.valueOf(stackData.get(index)) : "";
            stackLabels[STACK_ROWS - 1 - i].setText(text);         // i = 0 -> lowest line
        }
    }

    /** Creates one right-aligned, full-width line of the screen. */
    private Label createScreenLine() {
        Label line = new Label("");
        line.setMaxWidth(Double.MAX_VALUE);
        line.setAlignment(Pos.CENTER_RIGHT);
        line.setStyle("-fx-border-color: gray; -fx-padding: 4 8; -fx-font-size: 16;");
        return line;
    }

    /** Creates a key and places it in the keypad; a click sends its label to the controller. */
    private void addKey(GridPane keypad, String key, int column, int row) {
        Button button = new Button(key);
        button.setPrefWidth(KEY_WIDTH);
        button.setOnAction(event -> keyPressed(key));
        keypad.add(button, column, row);
    }

    /** Forwards a key press to the controller (does nothing until a controller is set). */
    private void keyPressed(String key) {
        if (controller != null) {
            controller.onButton(key);
        }
    }
}
