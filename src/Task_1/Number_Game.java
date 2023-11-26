package Task_1;
import java.util.Random;
import java.util.Scanner;
public class Number_Game {
    public static int getRandom(){
        Random randObj = new Random();
        return randObj.nextInt(100)+1;
    }
    public static void main(String[] args) {
        int randNum = getRandom();
        int guessNum;
        boolean got_guess = false;

        Scanner getInt = new Scanner(System.in);

        System.out.println("#################### Welcome to the number guessing game ####################");

        for (int i = 0; i < 5; i++) {
            System.out.printf("\nRound %d",i+1);
            System.out.print("\nGuess the random number: ");
            guessNum = getInt.nextInt();

            if (guessNum > randNum){
                System.out.println("Too high, Try Again.");
            } else if (guessNum < randNum) {
                System.out.println("Too low, Try Again.");
            } else {
                System.out.println("Congratulation you have guessed correctly.");
                System.out.printf("Your Score: %d/5",5-i);
                got_guess = true;
                break;
            }
        }
        if (!got_guess){
            System.out.println("\nThe random number was "+randNum);
        }
    }
}
