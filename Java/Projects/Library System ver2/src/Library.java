import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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
    public void displayBooks(){
        String isBookAvailable = null;
        BookData current;
//        System.out.printf("%-10s%-45s%-45s%-20s%15s%20s\n\n", "", "Title", "Author", "Genre", "Published Year", "Availability");
        for(int currBook = 0; currBook < bookList.size(); currBook++){
            current = bookList.get(currBook);
            isBookAvailable = (current.isBookAvailable) ? "Available" : "Not Available";
            System.out.println("\n*******************************************");
            System.out.printf("\nBook Number: %d\n", currBook +1);
            System.out.printf("\nBook-Id: %-10d\nTitle: %-45s\nAuthor: %-45s\nGenre : %-20s\nPublished Year: %-15d\nAvailability: %-20s\n", current.bookId, current.bookTitle, current.bookAuthor, current.bookGenre, current.publiYear, isBookAvailable);
        }
        System.out.println("\n*******************************************\n");


    }

}
