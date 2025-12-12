package Library;

import java.util.Scanner;

public class Student {
    String studentName;
    String regNum;
    Book[] borrowedBooks = new Book[3]; // max 3 books
    public int booksCount = 0;

    // Constructor with interactive input
    public Student(Scanner input) {
        System.out.print("Enter Student Name: ");
        this.studentName = input.nextLine();

        System.out.print("Enter Registration Number: ");
        this.regNum = input.nextLine();
    }

    // Borrow a book
    public void borrowBook(Book b) {
        if (booksCount < borrowedBooks.length) {
            borrowedBooks[booksCount++] = b;
            System.out.println(studentName + " borrowed " + b.bookName);
        } else {
            System.out.println("Cannot borrow more than 3 books.");
        }
    }

    // Return a book by index
    public void returnBook(int index) {
        if (index >= 0 && index < booksCount) {
            System.out.println(studentName + " returned " + borrowedBooks[index].bookName);
            borrowedBooks[index] = null;
            for (int i = index; i < booksCount - 1; i++) {
                borrowedBooks[i] = borrowedBooks[i + 1];
            }
            booksCount--;
        } else {
            System.out.println("Invalid book index.");
        }
    }

    // Show borrowed books
    public void showBorrowedBooks() {
        System.out.println(studentName + " has borrowed:");
        for (int i = 0; i < booksCount; i++) {
            System.out.println("- " + borrowedBooks[i].bookName);
        }
    }
}