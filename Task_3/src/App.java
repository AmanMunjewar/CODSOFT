import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static Database openFile() throws Exception {
        File file = new File("student_info.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        
        Database database = (Database) ois.readObject();
        ois.close();
        return database;
    }

    public static void closeFile(Database database) throws Exception {
        File file = new File("student_info.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(database);
        oos.close();
    }


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Database db = new Database();

        System.out.println("================== Welcome to student database ==================");
                
        System.out.println("Do you want to use a exsisting file(Y/n)");
        String choice = scan.nextLine();
        if (choice.equals("Y") || choice.equals("y")) {
            db = openFile();    
        }

        int ch;
        boolean isOpen=true;

        
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
            System.out.println();
            Thread.sleep(500);
            
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
                    closeFile(db);
                    isOpen=false;
                    break;
                default:
                    break;
            }
        }

        scan.close();
    }
}
