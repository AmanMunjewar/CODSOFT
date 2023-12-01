package Task_2;
import java.util.Scanner;

public class Word_Counter {
    static void countWord(){
        int wordCount=0;
        Scanner getWord = new Scanner(System.in);
        String inp_string = getWord.nextLine();

        char getChar;
        for (int i = 0; i < inp_string.length(); i++) {
            getChar = inp_string.charAt(i);
            if (getChar == ' ' || getChar == '\n'){
                wordCount++;
            }
        }
        System.out.println("Word Count: "+wordCount);
    }
    public static void main(String[] args) {
        System.out.print("Enter the string: ");
        countWord();
    }
}
