package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebView;
import javafx.scene.image.ImageView;
import java.io.IOException;


public class Controller extends Main {
    DictionaryManagement dm = new DictionaryManagement();
    //layout 1
    @FXML
    private Button Start;

    @FXML
    private ImageView imageView = new ImageView();

    @FXML
    void getStarted () throws IOException{
        Start.setVisible(false);
        imageView.setVisible(false);
        dm.insertFromFile();
    }
    //layout 2
    @FXML
    private Button speak;
    @FXML
    private Button Search;
    @FXML
    private Button File;
    @FXML
    private Button More;
    @FXML
    private Button AboutUs;
    @FXML
    private TextField textField;
    @FXML
    private WebView webView;

    //cai dat code cho button search
    @FXML
    void search (ActionEvent event){
        String tmp = textField.getText();
        System.out.println(dm.dictionary.list.get(0));
        if(dm.dictionaryLookup(tmp) != null) {

            webView.getEngine().loadContent(dm.dictionaryLookup(tmp).getMean());
        } else {
            webView.getEngine().loadContent("Khong co tu nay trong tu dien");
        }
    }
    @FXML
    void keyPress(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            String tmp = textField.getText();
            System.out.println(dm.dictionary.list.get(0));
            if(dm.dictionaryLookup(tmp) != null) {

                webView.getEngine().loadContent(dm.dictionaryLookup(tmp).getMean());
            } else {
                webView.getEngine().loadContent("Khong co tu nay trong tu dien");
            }
        }
    }

    //cai dat code cho button speak
    @FXML
    void speech(ActionEvent event){
        String text = textField.getText();
        Voice voice = new Voice("kevin16");
        voice.sayString(text);
    }
    //cai dat code cho File
    @FXML
    void file(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SORRY");
        alert.setHeaderText("WE WILL UPDTE THIS SOON");
        alert.show();
    }

    //cai dat code cho button More
    @FXML
    void getMore(ActionEvent event){
        Search.setVisible(false);
        File.setVisible(false);
        More.setVisible(false);
        AboutUs.setVisible(false);
        textField.setVisible(false);
        webView.setVisible(false);
        speak.setVisible(false);
    }

    // cai dat code cho button about us
    @FXML
    void getAboutUs(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dictionary Pro Evolution 2.0");
        alert.setHeaderText("Produced by:\n\nTran Long Dung\nNguyen Trung Anh\nNguyen Huu Nghia");
        alert.setContentText("Designed by CLBNS, Assembled in Duong Quang Ham");
        alert.show();
    }

    //layout 3

    @FXML
    private TextField word;
    @FXML
    private TextField mean;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private Button edit;
    @FXML
    private Button back;


    //cai dat code cho button back
    @FXML
    void getBack(ActionEvent event){
        Search.setVisible(true);
        File.setVisible(true);
        More.setVisible(true);
        AboutUs.setVisible(true);
        textField.setVisible(true);
        webView.setVisible(true);
        speak.setVisible(true);
    }

    //cai dat code cho button add
    @FXML
    void Add(ActionEvent event){
        dm.addWord(word.getText() , mean.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRM");
        alert.setHeaderText("DONE");
        alert.show();
        //System.out.println("check1");
    }

    //cai dat code cho button remove
    @FXML
    void Remove(ActionEvent event){
        dm.deleteWord(word.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRM");
        alert.setHeaderText("DONE");
        alert.show();
        System.out.println("check2");
    }

    //cai dat code cho button edit
    @FXML
    void Edit (ActionEvent event){
        if(dm.dictionaryLookup(word.getText()) != null ) {
            dm.fixWord(word.getText(), mean.getText());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRM");
        alert.setHeaderText("DONE");
        alert.show();
    }
}