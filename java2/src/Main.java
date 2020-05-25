import java.util.Scanner;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Main extends Application{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        launch(args);
        FirstMenu.runFirstMenu();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
