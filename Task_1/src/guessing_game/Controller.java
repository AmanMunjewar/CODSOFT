package guessing_game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
            try {
                FileWriter myWriter = new FileWriter("answer.txt");
                myWriter.write(Integer.toString(final_number));
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }
        if (guess_number<5) {
            guess_number+=1;
            try {
                titleLabel.setText("Chances "+Integer.toString(6-guess_number)+"/5");
                user_guess = Integer.parseInt(numberInput.getText());
                if (user_guess == final_number) {
                    outputLabel.setText("😊Congratulations");
                    titleLabel.setText("Your Score "+Integer.toString(6-guess_number)+"/5");
                } else if (user_guess > final_number) {
                    outputLabel.setText("☹ Too High");
                } else if (user_guess < final_number) {
                    outputLabel.setText("☹ Too low");
                }

            } catch (NumberFormatException e) {
                titleLabel.setText("Enter a valid Input");
                guess_number--;
            } catch (Exception e) {
                titleLabel.setText("Error!");
                guess_number--;
            }
        } else {
            titleLabel.setText("Game has ended! You Lost");
        }
    }
}