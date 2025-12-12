package Library;

import java.util.Scanner;

public class Students {
    Scanner input = new Scanner(System.in);
    Student[] theStudents = new Student[50];
    public static int count = 0;

    // Add a student
    public void addStudent(Student s) {
        for (int i = 0; i < count; i++) {
            if (s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
                System.out.println("Student with Reg Num " + s.regNum + " is already registered.");
                return;
            }
        }
        if (count < 50) {
            theStudents[count++] = s;
        }
    }

    // Show all students
    public void showAllStudents() {
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theStudents[i].studentName + "\t\t" + theStudents[i].regNum);
        }
    }

    // Find student by reg number
    public int isStudent() {
        System.out.print("Enter Reg Number: ");
        String regNum = input.nextLine();
        for (int i = 0; i < count; i++) {
            if (theStudents[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }
        System.out.println("Student is not registered. Get registered first.");
        return -1;
    }

    // Check out book
    public void checkOutBook(Books bookManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            bookManager.showAllBooks();
            Book b = bookManager.checkOutBook();
            if (b != null) {
                Student s = theStudents[studentIndex];
                s.borrowBook(b);
            } else {
                System.out.println("Book is not available.");
            }
        }
    }

    // Check in book
    public void checkInBook(Books bookManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            Student s = theStudents[studentIndex];
            s.showBorrowedBooks();
            System.out.print("Enter index (0-" + (s.booksCount - 1) + ") of book to return: ");
            int index = input.nextInt();
            input.nextLine(); // clear buffer
            if (index >= 0 && index < s.booksCount) {
                bookManager.checkInBook(s.borrowedBooks[index]);
                s.returnBook(index);
            } else {
                System.out.println("Invalid index.");
            }
        }
    }
}