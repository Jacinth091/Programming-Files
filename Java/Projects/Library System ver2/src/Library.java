import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Library {
    Object[][] defaultBookData = {

            {"BQ-101", "Don Quixote", "Miguel de Cervantes", "Fiction", 1605, true},
            {"AAW-205", "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", 1865, true},
            {"TAOHF-312", "The Adventures of Huckleberry Finn", "Mark Twain", "Adventure", 1884, true},
            {"TAOTS-404", "The Adventures of Tom Sawyer", "Mark Twain", "Adventure", 1876, true},
            {"TI-512", "Treasure Island", "Robert Louis Stevenson", "Adventure", 1883, true}
    };

//    BookData books = new BookData(null,null,null,0 ,0,false);

     List<BookData> bookList = new ArrayList<>();
     int length = defaultBookData.length ;
    List<String> authorList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();

    // Order - User Book List
    List<BookData> userBookCart = new ArrayList<>();



    public void initializeBook(){
        for(int bookIndex =0; bookIndex < length; bookIndex++){

            String bookId = (String) defaultBookData[bookIndex][0];
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
                System.out.println("\n******************************************************************************************************************************************");
                System.out.printf(" %-15s%-45s%-30s%-20s%-10s%-10s\n\n", "Serial" , "Title", "Author", "Genre", "Year", "Status");
                for(  currBook= 0; currBook < bookListSize; currBook++) {
                    current = bookList.get(currBook);
                    isBookAvailable = (current.isBookAvailable) ? "Available" : "Not Available";
                    System.out.printf(" %-15s%-45s%-30s%-20s%-10d%-10s\n", current.bookId, current.bookTitle, current.bookAuthor, current.bookGenre, current.publiYear, isBookAvailable);
                }
                System.out.println("******************************************************************************************************************************************");

                break;
            case 2: // Display all Book title, author, and genre
                System.out.println("\n******************************************************************************************************************************************");
                  System.out.printf("%-5s%-15s%-45s%-30s%-20s%-10s\n\n", "#" ,"Serial", "Title", "Author", "Genre", "Status");
                for(currBook = 0; currBook < bookListSize; currBook++){
                    current = bookList.get(currBook);
                    isBookAvailable = (current.isBookAvailable) ? "Available" : "Not Available";
                    System.out.printf("%-5d%-15s%-45s%-30s%-20s%-10s\n", (currBook + 1),current.bookId, current.bookTitle, current.bookAuthor, current.bookGenre, isBookAvailable);
                }
                System.out.println("\n******************************************************************************************************************************************");


                break;
            case 3: // Display all the Book title and availablity
                break;

            default:
                break;
        }
    }


    public  <T>  int getBookNumber(Scanner in, List <T> list, String option){
        int userIn = 0, length = list.size();
        boolean isValid = false;

        do{
            System.out.printf("\nEnter Book # you want to %s, 0 to cancel\n", option);
            System.out.print("Book Number: ");
            if(in.hasNextInt()){
                userIn = in.nextInt();
                in.nextLine();
                if(userIn <= length && userIn >= 0 ){
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

    public <T> BookData getBookFromList(int bookNumber, List<T> list){
        return (BookData) list.get(bookNumber - 1);
    }

    public <T> void setBookToFalse(int bookNumb, List<T> list){
        BookData currentBook = (BookData) list.get(bookNumb -1);
        currentBook.isBookAvailable = false;
    }
    public <T> void setBookToTrue(List<T> list, BookData orderedBook){
        BookData currentBook;
        int length = list.size();
        for(int currBook = 0; currBook < length; currBook++ ){
            currentBook = (BookData) list.get(currBook);
            if(currentBook.bookTitle == orderedBook.bookTitle){
                currentBook.isBookAvailable = true;
                break;
            }
        }

    }
    
    public <T> boolean checkBookStatus(BookData orderedBook, List<T> list){
        boolean flagValue = false;
        BookData checkBook;
        int length = list.size();
        for(int currBook = 0; currBook < length; currBook++ ){
            checkBook = (BookData) list.get(currBook);
            if(Objects.equals(checkBook.bookTitle, orderedBook.bookTitle)){
                if(checkBook.isBookAvailable){
                    flagValue = true;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        return flagValue;

    }

    public void optToOrderList(BookData bookData, boolean funcToDo){
        if(funcToDo){
            userBookCart.add(bookData);
        }
        else{
            userBookCart.remove(bookData);
        }


    }
    public <T> void  dispUserBookList(List<T> list){
        BookData current;
        int length = list.size();

        System.out.println("\n******************************************************************************************************************************************");

        System.out.printf("%-5s%-15s%-45s%-30s%-20s\n\n", "#" ,"Serial", "Title", "Author", "Genre");
        for(int currBook = 0; currBook < length; currBook++){
            current = bookList.get(currBook);
            System.out.printf("%-5d%-15s%-45s%-30s%-20s\n", (currBook + 1),current.bookId, current.bookTitle, current.bookAuthor, current.bookGenre);
        }
        System.out.println("\n******************************************************************************************************************************************");

    }
}
