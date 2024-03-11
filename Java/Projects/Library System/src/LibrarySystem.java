import java.util.*;

class Books{
    String bookTitle, bookAuthor, bookGenre,bookDueDate, bookAvailble;
    int bookId, numOfBooks;
    String[][] defaultBooks;

    public Books(String bookTitle, String bookAuthor, String bookGenre, String bookAvailble, int bookId, int numOfBooks) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookAvailble = bookAvailble;
        this.bookDueDate = "";
        this.bookId = bookId;
        this.numOfBooks = numOfBooks;
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
/*                {"The Pilgrim's Progress", "John Bunyan", "Allegory"},
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
                {"The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction"}*/
        };
    }
/*    @Override
    public String toString() {
        return String.format(
                "%-10d%-45s%-25s%-25s%-20s%-15d",
                bookId, bookTitle, bookAuthor, bookGenre, bookAvailble, numOfBooks);
    }*/
}
class Library{
//    Books books = new Books();
    public static Books book = new Books("None","None","None","None",0, 0);

    List<Books> libraryBookData;
    ArrayList<String> libraryBookTitle;
    ArrayList<String> libraryBookAuthor;
    ArrayList<String> libraryBookGenre;

    Library(){
        this.libraryBookTitle = new ArrayList<>();
        this.libraryBookAuthor = new ArrayList<>();
        this.libraryBookGenre = new ArrayList<>();
        this.libraryBookData = new ArrayList<>();
    }

    void initializeList(){
        String bookTitle, bookAuthor, bookGenre, bookAvailable = "Available";
        int numOfBooks = 10;
        for(byte bookIndex = 0; bookIndex < book.defaultBooks.length; bookIndex++){

            libraryBookTitle.add(book.defaultBooks[bookIndex][0]);
            libraryBookAuthor.add(book.defaultBooks[bookIndex][1]);
            libraryBookGenre.add(book.defaultBooks[bookIndex][2]);

            bookTitle = book.defaultBooks[bookIndex][0];
            bookAuthor = book.defaultBooks[bookIndex][1];
            bookGenre = book.defaultBooks[bookIndex][2];

            libraryBookData.add(new Books(bookTitle, bookAuthor, bookGenre, bookAvailable, bookIndex + 1, numOfBooks));

        }


    }


    void librarV() {
        // Implement a basis search function for the books


    }

}
class Records{
    String[] recordsOptions = {"View Available Book/s", "Order Book/s", "Book-Cart", "Renew Book", "Checkout Book/s"};
    String[] recordCheckout;


}



class LibrarySystem{
    public static Books book;
    public static Books currentAtt;
    public static Library library = new Library();
    public static Records records = new Records();

    public static Scanner in = new Scanner(System.in);
    static byte userResponse = 0;
    static byte userChoice = 0;


    public static void main(String[] args) {
        char userPrompt;
        boolean isValid = false, exitLoop = false;

        library.initializeList();
        System.out.println("---------------------------------------");
        System.out.println("\t \tLibrary System ver 1.");
        System.out.println("---------------------------------------");

        do {
//            System.out.printf("userChoice: %d", userChoice);
            displayList(records.recordsOptions);
            getInputFromList(records.recordsOptions);
//            System.out.printf("userChoice: %d", userChoice);


            switch (userChoice){
                case 1:
                    displayList(library.libraryBookData);
                    System.out.print("------->>");
                    userResponse = in.nextByte();

//                    getInputFromList(library.libraryBookData);
//                    System.out.printf("%s\n", library.libraryBookTitle.get(userResponse));
                    break;
                case 2:
/*                    displayList(library.libraryBooks);
                    userResponse = getInputFromList(library.libraryBooks);*/
                    displayList(library.libraryBookData);
                    getInputFromList(library.libraryBookData);

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




        }while(!exitLoop);



    }

    // Display arrays, arrylists, lists
    static <T> void displayList(T[] array){
        System.out.println("***************************************\n");
        for(byte  i = 0; i < array.length; i++){
            System.out.printf("%s: %s\n", (i+1), array[i]);
        }
        System.out.println("\n0: Exit Program");
        System.out.println("\n***************************************");

    }
    static <T> void displayList(T[][] array){
        System.out.println("***************************************\n");
        for(byte  i = 0; i < array.length; i++){
            System.out.printf("%s: %s\n", (i+1), Arrays.toString(array[i]));
        }
        System.out.println("\n0: Exit Program");
        System.out.println("\n***************************************");

    }
    static <T> void displayList(ArrayList<T> array){
        System.out.println("***************************************\n");
        for(byte  i = 0; i < array.size(); i++){
            System.out.printf("%s: %s\n", (i+1), array.get(i));
        }
        System.out.println("\n0: Exit Program");
        System.out.println("\n***************************************");

    }
    static <T> void displayList(List<T> array){

        if(userChoice == 1){
            System.out.println("***************************************\n");
            System.out.printf("%-10s%-45s%-25s%-25s\n\n", "Id No.", "Title", "Author", "Genre");
            for (T t : array) {

                currentAtt = (Books) t;
                System.out.printf("%-10d%-45s%-25s%-25s\n", currentAtt.bookId, currentAtt.bookTitle, currentAtt.bookAuthor, currentAtt.bookGenre);
            }
            System.out.println("\n***************************************");
            System.out.println("\n0: Go Back");
        }
        else{
            System.out.println("***************************************\n");
            System.out.printf("%-10s%-45s%-25s%-25s%-20s%-15s\n\n", "Id No.", "Title", "Author", "Genre", "Stock", "No. of Stock" );
            for (T t : array) {

                Books currentAtt = (Books) t;
                System.out.printf("%-10s%-45s%-25s%-25s%-20s%-15s\n", currentAtt.bookId, currentAtt.bookTitle, currentAtt.bookAuthor, currentAtt.bookGenre, currentAtt.bookAvailble, currentAtt.numOfBooks);
            }
            System.out.println("\n***************************************");
            System.out.println("\n0: Go Back");
        }



    }

    // Get Input from List
    static <T> void getInputFromList(T[] array){
        userChoice = 0;
        userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.length);


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.length && userResponse  >= 0){
                    userChoice = userResponse;
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



    }
    static <T> void getInputFromList(T[][] array){
        userChoice = 0;
        userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.length);


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.length && userResponse  >= 0){
                    userChoice = userResponse;

                    if(userResponse == 0){
                        isValid = true;
                    }
                    else{
                        System.out.printf("Your Response %d: %s\n", userResponse, Arrays.toString(array[userResponse - 1]));
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



    }
    static <T> void getInputFromList(ArrayList<T> array){
        userChoice = 0;
        userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.size());


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.size() && userResponse  >= 0){
                    userChoice = userResponse;

                    if(userResponse == 0){
                        isValid = true;
                    }
                    else{
                        System.out.printf("Your Response %d: %s\n", userResponse, array.get(userResponse-1));
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



    }
    static <T> void getInputFromList(List<T> array){
        userChoice = 0;
        userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.size());


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.size() && userResponse  >= 0){
                    userChoice = userResponse;

                    if(userResponse == 0){
                        System.exit(0);
                        isValid = true;
                    }
                    else{
                        currentAtt = (Books) library.libraryBookData.get(userResponse-1);
                        System.out.printf("You Chose\nBook-Title:  %s\nBook-Author: %s\nBook-Genre:  %s\n", currentAtt.bookTitle, currentAtt.bookAuthor, currentAtt.bookGenre);
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



    }

//    static <T> String fetchItem(){
//        for(byte i = 0; i < list)
//
//
//    }

 /*   static <T> int getInputFromList(ArrayList<ArrayList<T>> array){
        byte userResponse = 0;
        boolean isValid = false;


        do{
            System.out.printf("\n0 to EXIT, Enter #1 to #%d to Select", array.size());


            try{
                userResponse = 0;
                System.out.print("\n--->>: ");
                userResponse = in.nextByte();
                in.nextLine();

                if(userResponse <= array.size() && userResponse  >= 0){
                    if(userResponse == 0){
                        isValid = true;
                    }
                    else{
                        System.out.printf("Your Response %d: %s\n", userResponse, array.get(userResponse-1));
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



    }*/

}