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

        Scanner getInt = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("\nRound "+i);
            System.out.println("The number: "+randNum);
            System.out.print("Guess the random number: ");
            guessNum = getInt.nextInt();

            if (guessNum > randNum){
                System.out.println("Too high, Try Again.");
            } else if (guessNum < randNum) {
                System.out.println("Too low, Try Again.");
            } else {
                System.out.println("Congratulation you have guessed correctly.");
                break;
            }
        }
    }
}
