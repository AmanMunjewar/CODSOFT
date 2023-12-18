import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {
    @FXML
    TextField inputField;

    public void counter(ActionEvent event){
        Alert alert = new Alert(AlertType.INFORMATION);
        
        String userString = inputField.getText();
        alert.setTitle("Word Counter");
        alert.setContentText("Word Count: "+wordCount(userString));
        alert.setHeaderText("Computed word count");
        alert.show();
    }

    public void getFile(ActionEvent event) throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            List<String> str = Files.readAllLines(file.toPath());
            String user_str="";
            for (int i = 0; i < str.size(); i++) {
                user_str += str.get(i);
            }
            inputField.setText(user_str);
            counter(event);
        }
    }

    public int wordCount(String sentence){
        int wordCount=0;
        sentence = sentence.trim();
        String splitString[] = sentence.split(" ");
        int str_len = splitString.length;

        for (int i = 0; i < str_len; i++) {
            if (!splitString[i].isEmpty()) {
                wordCount++;   
            }  
        }
        return wordCount;
    }
}
