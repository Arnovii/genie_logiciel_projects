import controller.CalculatorController;
import java.util.Scanner;
import model.CalculatorModel;
import view.CalculatorConsoleView;

/**
 * Tests the calculator in the console, with the same model and controller as the GUI.
 * Type keys separated by spaces, for example: 3 <> 4 +
 * Numbers can use a comma or a dot (12,5 or 12.5). Type "quit" to stop.
 */
public class Main {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorConsoleView view = new CalculatorConsoleView();
        CalculatorController controller = new CalculatorController(model, view);
        model.setController(controller);

        view.affiche();
        System.out.println("Keys: numbers, <> + - * / +/- pop drop swap clear dropAll, quit");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("quit")) {
                break;
            }
            for (String token : line.split("\\s+")) {
                pressKeys(controller, token);
            }
        }
    }

    /** A number is typed digit by digit; any other token is one key. */
    private static void pressKeys(CalculatorController controller, String token) {
        if (token.matches("[0-9]+([.,][0-9]+)?")) {
            for (char c : token.replace('.', ',').toCharArray()) {
                controller.onButton(String.valueOf(c));
            }
        } else if (!token.isEmpty()) {
            controller.onButton(token);
        }
    }
}
    