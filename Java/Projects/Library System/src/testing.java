import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testing{
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book("", "", "" ,"", 0, 0);
        Scanner in = new Scanner(System.in);
        // Column names

        String[][] data = new String[][]{
                {"Don Quixote", "Miguel de Cervantes", "Fiction"},
                {"Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy"},
                {"The Adventures of Huckleberry Finn", "Mark Twain", "Adventure"},
                {"The Adventures of Tom Sawyer", "Mark Twain", "Adventure"},
                {"Treasure Island", "Robert Louis Stevenson", "Adventure"},
                {"Pride and Prejudice", "Jane Austen", "Romance"},
                {"Wuthering Heights", "Emily Brontë", "Gothic Fiction"},
                {"Jane Eyre", "Charlotte Brontë", "Gothic Fiction"},
                {"Moby Dick", "Herman Melville", "Adventure"},
                {"The Scarlet Letter", "Nathaniel Hawthorne", "Historical Fiction"},
                {"Gulliver's Travels", "Jonathan Swift", "Satire"},
                {"The Pilgrim's Progress", "John Bunyan", "Allegory"},
                {"A Christmas Carol", "Charles Dickens", "Fiction"},
                {"David Copperfield", "Charles Dickens", "Fiction"},
                {"A Tale of Two Cities", "Charles Dickens", "Historical Fiction"},
                {"Little Women", "Louisa May Alcott", "Coming-of-Age"},
                {"Great Expectations", "Charles Dickens", "Fiction"},
/*                {"The Hobbit, or, There and Back Again", "J.R.R. Tolkien", "Fantasy"},
                {"Frankenstein, or, the Modern Prometheus", "Mary Shelley", "Gothic Fiction"},
                {"Oliver Twist", "Charles Dickens", "Fiction"},
                {"Uncle Tom's Cabin", "Harriet Beecher Stowe", "Anti-Slavery Novel"},
                {"Crime and Punishment", "Fyodor Dostoyevsky", "Psychological Fiction"},
                {"Madame Bovary: Patterns of Provincial life", "Gustave Flaubert", "Realism"},
                {"The Return of the King", "J.R.R. Tolkien", "Fantasy"},
                {"Dracula", "Bram Stoker", "Gothic Fiction"},
                {"The Three Musketeers", "Alexandre Dumas", "Historical Adventure"},
                {"Brave New World", "Aldous Huxley", "Dystopian Fiction"},
                {"War and Peace", "Leo Tolstoy", "Historical Fiction"},
                {"To Kill a Mockingbird", "Harper Lee", "Southern Gothic"},
                {"The Wizard of Oz", "L. Frank Baum", "Fantasy"},
                {"Les Misérables", "Victor Hugo", "Historical Fiction"},
                {"The Secret Garden", "Frances Hodgson Burnett", "Children's Literature"},
                {"Animal Farm", "George Orwell", "Political Satire"},
                {"The Great Gatsby", "F. Scott Fitzgerald", "Fiction"},
                {"The Little Prince", "Antoine de Saint-Exupéry", "Children's Literature"},
                {"The Call of the Wild", "Jack London", "Adventure"},
                {"20,000 Leagues Under the Sea", "Jules Verne", "Adventure"},
                {"Anna Karenina", "Leo Tolstoy", "Realist Fiction"},
                {"The Wind in the Willows", "Kenneth Grahame", "Children's Literature"},
                {"The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction"}*/
        };

        for(byte bookIndex = 0; bookIndex < data.length; bookIndex++){

            String title = data[bookIndex][0];
            String author = data[bookIndex][1];
            String genre = data[bookIndex][2];

            bookList.add(new Book(title, author, genre, "Available", bookIndex + 1, 10));
        }
        System.out.printf("%-10s%-45s%-25s%-25s%-20s%-15s\n", "Id No.", "Title", "Author", "Genre", "Stock", "No. of Stock" );
        for(byte bookIndex = 0; bookIndex < bookList.size(); bookIndex++){

            Book currentBook = bookList.get(bookIndex);
            System.out.printf("%-10d%-45s%-25s%-25s\n", currentBook.id, currentBook.bookTitle, currentBook.bookAuthor, currentBook.bookGenre);
//            System.out.printf("%s\n", bookList.get(bookIndex));
        }
        System.out.printf("BookList size: %d\n", bookList.size());
        System.out.printf("Book Title: %s\n", book.bookTitle);


        int response;

        System.out.print("Input response: ");
        response = in.nextInt();
        in.nextLine();



        if (response > 0 && response <= bookList.size()) {
            Book selectedBook = bookList.get(response - 1);
            selectedBook.bookAvailable = "Not Available";
            System.out.println("Book status updated successfully.");
        } else {
            System.out.println("Invalid input. Please enter a valid book ID.");
        }
        for(byte bookIndex = 0; bookIndex < bookList.size(); bookIndex++){

            Book currentBook = bookList.get(bookIndex);
            System.out.printf("%-10d%-45s%-45s%-45s%-45s\n", currentBook.id, currentBook.bookTitle, currentBook.bookAuthor, currentBook.bookGenre, currentBook.bookAvailable);
        }






    }

/*    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }*/


}

class Book{


    int id, numOfBook;
    String bookAuthor, bookTitle, bookGenre, bookAvailable;
//    boolean isAvailable;

    Book(String bookTitle, String bookAuthor, String bookGenre, String bookAvailable,int id, int numOfBook){
        this.id = id;
        this.numOfBook = numOfBook;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookAvailable = bookAvailable;
    }
}
