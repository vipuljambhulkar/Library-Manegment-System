package Library;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("******************** Welcome to the Vipul's Library! ********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("**********************************************************************");

        Books ob = new Books();       // manages books
        Students obStudent = new Students(); // manages students

        int choice;
        int searchChoice;

        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Upgrade Book Quantity");
            System.out.println("3. Search Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Add Student");
            System.out.println("6. Show All Students");
            System.out.println("7. Check Out Book");
            System.out.println("8. Check In Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Book b = new Book(input); // interactive book creation
                    ob.addBook(b);
                    break;
                case 2:
                    ob.upgradeBookQty();
                    break;
                case 3:
                    System.out.println("Press 1 to Search with Book Serial No.");
                    System.out.println("Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();
                    if (searchChoice == 1) ob.searchBySno();
                    else if (searchChoice == 2) ob.searchByAuthorName();
                    break;
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    Student s = new Student(input);
                    obStudent.addStudent(s);
                    break;
                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }
        } while (choice != 0);

        input.close();
    }
}