package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("EffectifeTextEditor");
        primaryStage.setScene(new Scene(root, 490, 540));
        primaryStage.setResizable(false);
        primaryStage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setResizable(false);
        alert.setContentText("Hello!\nPlease enter the Windows username in the 'User' field."+
                "\nAlso enter the name of file or file you want to create in the 'Path to file' field.\n"+
                        "Files must be on your desktop so that you can open them and create them on it.\n"+
                            "This is done for comfort :)");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
