import controller.CalculatorController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CalculatorModel;
import view.CalculatorGUI;

/**
 * Starts the JavaFX calculator: creates the model, the view and the controller,
 * then connects them.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        CalculatorModel model = new CalculatorModel();
        CalculatorGUI gui = new CalculatorGUI();
        CalculatorController controller = new CalculatorController(model, gui);
        model.setController(controller);   // model -> controller (callback change)
        gui.setController(controller);     // view -> controller (onButton)

        stage.setTitle("RPN Calculator");
        stage.setScene(gui);
        stage.show();
        gui.affiche();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
