package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField userField;

    @FXML
    private TextField pathField;

    @FXML
    private Button newFileButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Button saveFileButton;

    @FXML
    private TextArea textArea;

    private String filePath;

    @FXML
    void initialize() {

        newFileButton.setOnAction(event ->
        {
            textArea.clear();
            if (pathField.getText().isEmpty() || userField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setResizable(false);
                alert.setContentText("Enter path file!");
                alert.showAndWait();
            } else {
                filePath = "C:/Users/" + userField.getText() + "/Desktop/" + pathField.getText();
                File newFile = new File(filePath);
                try {
                    boolean created = newFile.createNewFile();
                    if (created)
                        System.out.println("Create new file " + pathField.getText());
                } catch (IOException ex) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setResizable(false);
                    alert.setContentText("The file was not created!\nPlease enter the name of the file and user again!");
                    alert.showAndWait();
                    System.out.println(ex.getMessage());
                }
            }
        });

        openFileButton.setOnAction(event ->
        {
            textArea.clear();
            if (pathField.getText().isEmpty() || userField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setResizable(false);
                alert.setContentText("Enter path to file!");
                alert.showAndWait();
            } else {
                filePath = "C:/Users/" + userField.getText() + "/Desktop/" + pathField.getText();
                try {
                    String allText = new String(Files.readAllBytes(Paths.get(filePath)));
                    textArea.setText(allText);
                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setResizable(false);
                    alert.setContentText("Invalid file name!");
                    alert.showAndWait();

                    e.printStackTrace();
                }
            }
        });

        saveFileButton.setOnAction(event ->
        {
            if (pathField.getText().isEmpty() || userField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setResizable(false);
                alert.setContentText("Enter path to file!");
                alert.showAndWait();
            } else {
                filePath = "C:/Users/" + userField.getText() + "/Desktop/" + pathField.getText();
                try {
                    FileWriter fileWriter = new FileWriter(filePath);
                    fileWriter.write(textArea.getText().replaceAll("\n", "\r\n"));
                    fileWriter.flush();
                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setResizable(false);
                    alert.setContentText("Invalid file name!");
                    alert.showAndWait();

                    e.printStackTrace();
                }
            }
        });
    }
}


