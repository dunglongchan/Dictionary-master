package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Dictionary Pro Evolution 2.0");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) { launch(args);
    }
}
