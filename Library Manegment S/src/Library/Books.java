package Library;

import java.util.Scanner;

public class Books {
    Book[] theBooks = new Book[50];
    public static int count = 0;
    Scanner input = new Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2) {
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("Book of this Name Already Exists.");
            return 0;
        }
        if (b1.sNo == b2.sNo) {
            System.out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (compareBookObjects(b, theBooks[i]) == 0) return;
        }
        if (count < 50) {
            theBooks[count++] = b;
        } else {
            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno() {
        System.out.print("Enter Serial No of Book: ");
        int sNo = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(theBooks[i]);
                return;
            }
        }
        System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    public void searchByAuthorName() {
        input.nextLine(); // clear buffer
        System.out.print("Enter Author Name: ");
        String authorName = input.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                System.out.println(theBooks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No Books of " + authorName + " Found.");
    }

    public void showAllBooks() {
        System.out.println("S.No\tName\tAuthor\tAvailable Qty\tTotal Qty");
        for (int i = 0; i < count; i++) {
            System.out.println(theBooks[i]);
        }
    }

    public void upgradeBookQty() {
        System.out.print("Enter Serial No of Book: ");
        int sNo = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.print("Enter No of Books to be Added: ");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;
            }
        }
    }

    public int isAvailable(int sNo) {
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) return i;
                System.out.println("Book is Unavailable.");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number " + sNo + " Available in Library.");
        return -1;
    }

    public Book checkOutBook() {
        System.out.print("Enter Serial No of Book to be Checked Out: ");
        int sNo = input.nextInt();
        int bookIndex = isAvailable(sNo);
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.sNo == theBooks[i].sNo) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}