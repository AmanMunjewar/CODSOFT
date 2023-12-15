package guessing_game;

import java.util.Random;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField numberInput;
    @FXML
    Button submitButton;
    @FXML
    Label outputLabel, titleLabel;
    
    private int guess_number=0;
    private int user_guess;
    private int final_number;

    public void guess(ActionEvent event){
        if (guess_number == 0) {
            Random randObj = new Random();
            final_number = randObj.nextInt(100)+1;
        }
        if (guess_number<5) {
            guess_number+=1;
            try {
                user_guess = Integer.parseInt(numberInput.getText());
                outputLabel.setText(Integer.toString(final_number));

            } catch (NumberFormatException e) {
                titleLabel.setText("Enter a valid Input");
            } catch (Exception e) {
                titleLabel.setText("Error!");
            }
        } else {

        }
    }
}