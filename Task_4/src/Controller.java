import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField textField;
    @FXML
    RadioButton depositButton, withdrawButton;
    @FXML
    Label outputLabel;

    ATM atm = new ATM();

    public void action(ActionEvent event){
        double amount;
        try {
            amount = Integer.parseInt(textField.getText());    
        } catch (NumberFormatException e) {
            outputLabel.setText("Enter a valid amount");
            return;
        }
        
        if (depositButton.isSelected()) {
            atm.deposit(amount);
            outputLabel.setText("Your balance: "+atm.getBalance());
        } else {
            if (atm.isValidWithdrawal(amount)) {
                atm.withdraw(amount);
                outputLabel.setText("Your balance: "+atm.getBalance());
            } else {
                outputLabel.setText("Not enough balance");
            }
        }
    }

    public void getBalance(ActionEvent event){
        outputLabel.setText("Your balance: "+atm.getBalance());
    }
}
