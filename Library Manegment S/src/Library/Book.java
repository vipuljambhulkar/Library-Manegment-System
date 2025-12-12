package Library;

public class Book {
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    // Interactive constructor
    public Book(java.util.Scanner input) {
        System.out.print("Enter Serial No of Book: ");
        this.sNo = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Enter Book Name: ");
        this.bookName = input.nextLine();

        System.out.print("Enter Author Name: ");
        this.authorName = input.nextLine();

        System.out.print("Enter Quantity of Books: ");
        this.bookQty = input.nextInt();
        this.bookQtyCopy = this.bookQty;
    }

    // Direct constructor
    public Book(int sNo, String bookName, String authorName, int qty) {
        this.sNo = sNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookQty = qty;
        this.bookQtyCopy = qty;
    }

    @Override
    public String toString() {
        return sNo + "\t" + bookName + "\t" + authorName + "\t" + bookQtyCopy + "\t" + bookQty;
    }
}