import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Database db = new Database();
        Scanner scan = new Scanner(System.in);
        int ch;
        boolean isOpen=true;

        System.out.println("================== Welcome to student database ==================");
        
        while (isOpen) {
            System.out.println("\n1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student info");
            System.out.println("4. Edit student info");
            System.out.println("5. Display all student info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                ch = scan.nextInt();
                if (ch<1 || ch>6) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice try again!\n");
                Thread.sleep(1000);
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            
            switch (ch) {
                case 1:
                    db.addStudent();
                    break;
                case 2:
                    db.removeStudent();
                    break;
                case 3:
                    db.searchStudent();
                    break;
                case 4:
                    db.editInfo();
                    break;
                case 5:
                    db.displayAll();
                    break;
                case 6:
                    db.close();
                    isOpen=false;
                    break;
                default:
                    break;
            }
        }

        scan.close();
    }
}
