import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;
class Books{
    String bookTitle, bookAuthor, bookGenre,bookDueDate;
    String[][] defaultBooks;

    public Books() {
        this.bookTitle = "";
        this.bookAuthor = "";
        this.bookGenre = "";
        this.bookDueDate = "";
        this.defaultBooks = new String[][]{
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
                {"The Hobbit, or, There and Back Again", "J.R.R. Tolkien", "Fantasy"},
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
                {"The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction"}
        };
    }
}
class Library{
    Books books = new Books();
    ArrayList<ArrayList<String>> libraryBooks = new ArrayList<ArrayList<String>>();

    void libraryBookList(){
        for(byte i = 0; i < books.defaultBooks.length; i++){
            // Add the 2d normal Array Items title, author, genre to ArrayList
        }
    }

    void librarySearch() {
        // Implement a basis search function for the books
    }

}
class Records{
    String[] recordsOptions = {"Search Available Book/s", "Order Book/s", "Book-Cart", "Renew Book", "Checkout Book/s"};
    String[] recordCheckout;


}



class LibrarySystem{
    public static Books book = new Books();
    public static Library library = new Library();
    public static Records records = new Records();

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char userPrompt;
        int userChoice;
        boolean isValid = false, exitLoop = false;


        System.out.println("---------------------------------------");
        System.out.println("\t \tLibrary System ver 1.");
        System.out.println("---------------------------------------");

        do {
            displayList(records.recordsOptions);
            userChoice = getInputFromList(records.recordsOptions);

            switch (userChoice){
                case 1:
                    System.out.println("BOBO!");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                case -1:
                    break;

                default:
                    break;
            }




        }while(true);



    }
    static void displayList(String[] array){
        System.out.println("***************************************\n");
        for(byte  i = 0; i < array.length; i++){
            System.out.printf("%s: %s\n", (i+1), array[i]);
        }
        System.out.println("\n0: Exit Program");
        System.out.println("\n***************************************");

    }
    static int getInputFromList(String[] array){
        byte userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.length);


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.length && userResponse  >= 0){
                    if(userResponse == 0){
                        isValid = true;
                    }
                    else{
                        System.out.printf("Your Response %d: %s\n", userResponse, array[userResponse-1]);
                        isValid = true;
                        break;
                    }
                }
                else{
                    System.out.println("\n---------------------------------------");
                    System.out.println("\t   Invalid Input, Try again!");
                    System.out.println("---------------------------------------");
                    displayList(array);
                }
            }catch(InputMismatchException e){
                System.out.println("\n---------------------------------------");
                System.out.println("\t   Invalid Input, Try again!");
                System.out.println("---------------------------------------");
                in.nextLine();
                displayList(array);
            }
        }while(!isValid);
        return userResponse;


    }


}