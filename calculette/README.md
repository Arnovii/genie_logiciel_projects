# Switching Between GUI and Console Mode

This project has two entry points that share the same **Model** and **Controller**. The only difference is the **View**:

- `App.java` → Graphical interface (`CalculatorGUI`).
- `Main.java` → Console interface (`CalculatorConsoleView`).

This demonstrates the **MVC (Model-View-Controller)** architecture: the same application logic can work with different user interfaces.

## Dependencies: JavaFX 27 (Windows x64)

1. Download [JavaFX 27](https://gluonhq.com/products/javafx/#downloads).
2. Select the following options:
   - Version: **JavaFX 27**
   - Operating System: **Windows**
   - Architecture: **x64**
   - Type: **SDK** (not jmods).
3. Extract the downloaded archive.
4. Move the `javafx-sdk-27...` folder to `C:\` and rename it to exactly `javafx-sdk-27`.

## Configure JavaFX (One-Time Setup)

Open PowerShell and run:

```powershell
setx JDK_JAVA_OPTIONS "--module-path C:\javafx-sdk-27\lib --add-modules javafx.controls --enable-native-access=javafx.graphics"
```

Restart PowerShell after running the command.

Running the Application
Open PowerShell in the project directory.

GUI Mode:
```java .\App.java```

Console Mode:
```java .\Main.java```


