import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database implements Serializable{
    ArrayList<Student> student_list = new ArrayList<Student>();

    public void addStudent() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        int roll, grade;
        String name;
        try {
            System.out.print("Enter the Roll no.: ");
            roll = scan.nextInt();
            System.out.print("Enter the name: ");
            name = scan.next();
            System.out.print("Enter the grade: ");
            grade = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input try again");
            Thread.sleep(1000);
            return;
        } catch (Exception e){
            e.printStackTrace();
            return;
        } 
        student_list.add(new Student(roll, name, grade));
    }

    public void removeStudent() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the roll no. to remove: ");
        int roll;

        try {
            roll = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input try again");
            Thread.sleep(1000);
            return;
        } catch (Exception e){
            e.printStackTrace();
            return;
        } 

        for (int i = 0; i < student_list.size(); i++) {
            if (roll == student_list.get(i).getRoll()) {
                student_list.remove(i);
                return;
            }
        }
        System.out.println("Roll no. "+roll+" Not found");
    }

    public void searchStudent() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the roll no. to search: ");
        int roll;

        try {
            roll = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input try again");
            Thread.sleep(1000);
            return;
        } catch (Exception e){
            e.printStackTrace();
            return;
        } 

        System.out.println(String.format("%4s %7s %6s", "Roll", "Name", "Grade"));
        for (Student student : student_list) {
            if (roll == student.getRoll()) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Roll no. "+roll+" Not found");
    }

    public void editInfo() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the roll no. to edit: ");
        int roll;

        try {
            roll = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input try again");
            Thread.sleep(1000);
            return;
        } catch (Exception e){
            e.printStackTrace();
            return;
        } 

        for (int i = 0; i < student_list.size(); i++) {
            if (roll == student_list.get(i).getRoll()) {
                System.out.print("Enter the new Roll no.: ");
                roll = scan.nextInt();
                System.out.print("Enter the new Name: ");
                String name = scan.next();
                System.out.print("Enter the new Grade: ");
                int grade = scan.nextInt();
                student_list.set(i, new Student(roll, name, grade));
                return;
            }
        }
        System.out.println("Roll no. "+roll+" Not found");
    }

    public void displayAll(){
        System.out.println(String.format("%4s %7s %6s", "Roll", "Name", "Grade"));
        for (Student student : student_list) {
            student.displayInfo();    
        }
    }
}
