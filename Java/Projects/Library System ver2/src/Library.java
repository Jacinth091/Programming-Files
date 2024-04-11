import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
     Object[][] defaultBookData =
 {
     {1, "Don Quixote", "Miguel de Cervantes", "Fiction", 1605, true},
     {2, "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", 1865, true},
     {3, "The Adventures of Huckleberry Finn", "Mark Twain", "Adventure", 1884, true},
     {4, "The Adventures of Tom Sawyer", "Mark Twain", "Adventure", 1876, true},
     {5, "Treasure Island", "Robert Louis Stevenson", "Adventure", 1883, true}
 };
    BookData books = new BookData(null,null,null,0 ,0,false);

     List<BookData> bookList = new ArrayList<>();
     int length = defaultBookData.length ;
    List<String> authorList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();

    // Order - User Book List
    List<BookData> userBookCart = new ArrayList<>();



    public void initializeBook(){
        for(int bookIndex =0; bookIndex < length; bookIndex++){

            int bookId = (int) defaultBookData[bookIndex][0];
            String title = (String) defaultBookData[bookIndex][1];
            String author = (String) defaultBookData[bookIndex][2];
            String genre = (String) defaultBookData[bookIndex][3];
            int publiYear = (int) defaultBookData[bookIndex][4];
            boolean isBookAvailable = (boolean) defaultBookData[bookIndex][5];

            authorList.add(author);
            titleList.add(title);
            genreList.add(genre);

            bookList.add(new BookData(author, title, genre, bookId, publiYear, isBookAvailable));
        }

    }
    public void displayBooks(int indicator){
        String isBookAvailable = null;
        BookData current;
        int currBook, bookListSize = bookList.size();
//        System.out.printf("%-10s%-45s%-45s%-20s%15s%20s\n\n", "", "Title", "Author", "Genre", "Published Year", "Availability");

        switch (indicator)
        {
            case 1: // Display All Book Data
                for(  currBook= 0; currBook < bookListSize; currBook++){
                    current = bookList.get(currBook);
                    isBookAvailable = (current.isBookAvailable) ? "Available" : "Not Available";
                    System.out.println("************************************************");
                    System.out.printf("Book Number: %d\n", currBook +1);
                    System.out.printf("\nId#: %-10d\nTitle: %-45s\nAuthor: %-45s\nGenre : %-20s\nPublished Year: %-15d\nAvailability: %-20s\n", current.bookId, current.bookTitle.toUpperCase(), current.bookAuthor.toUpperCase(), current.bookGenre.toUpperCase(), current.publiYear, isBookAvailable.toUpperCase());

                }
                System.out.println("************************************************\n");


                break;
            case 2: // Display all Book title, author, and genre
                System.out.println("\n*********************************************************************************************************");
                  System.out.printf("%-5s%-45s%-30s%-20s\n", "#" , "Title", "Author", "Genre");
                for(currBook = 0; currBook < bookListSize; currBook++){
                    current = bookList.get(currBook);
                    System.out.printf("\n%-5d%-45s%-30s%-20s\n", (currBook + 1), current.bookTitle.toUpperCase(), current.bookAuthor.toUpperCase(), current.bookGenre.toUpperCase());
                }
                System.out.println("*********************************************************************************************************");

                break;
            case 3: // Display all the Book title and availablity
                break;

            default:
                break;
        }
    }


    public int getBookNumber(Scanner in){
        int userIn = 0, length = bookList.size();
        boolean isValid = false;

        do{
            System.out.print("\nEnter Book # you want to order\n");
            System.out.print("Book Number: ");
            if(in.hasNextInt()){
                userIn = in.nextInt();
                in.nextLine();
                if(userIn <= length && userIn > 0 ){
                    isValid = true;
                }
                else{
                    System.out.print("\nBook Not Found!, try again\n");
                }
            }
            else {
                System.out.print("\nInvalid Input, try again!\n");
                in.nextLine();
            }

        }while(!isValid);

        return userIn;
    }

    public BookData getBookFromList(int bookNumber){
        return bookList.get(bookNumber - 1);
    }
    public void addBookToOrderList(BookData bookToAdd){
        userBookCart.add(bookToAdd);
    }
    public <T> void  dispUserBookList(List<T> list){
        BookData current;
        int length = list.size();

        System.out.println("\n*********************************************************************************************************");
        System.out.printf("%-10s%-45s%-30s%-20s\n","Serial #","Title", "Author", "Genre");
        for(int currBook = 0; currBook < length; currBook++){
            current = (BookData) list.get(currBook);
            System.out.printf("\n%-10d%-45s%-30s%-20s\n",current.bookId, current.bookTitle.toUpperCase(), current.bookAuthor.toUpperCase(), current.bookGenre.toUpperCase());
        }
        System.out.println("*********************************************************************************************************\n");
    }
}
