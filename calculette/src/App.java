import javafx.application.Application;
import javafx.stage.Stage;
import view.CalculatorGUI;

/**
 * Starts the JavaFX calculator.
 * For now it only shows the window, so the view can be checked before the controller exists.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        CalculatorGUI gui = new CalculatorGUI();

        stage.setTitle("RPN Calculator");
        stage.setScene(gui);
        stage.show();
        gui.affiche();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
