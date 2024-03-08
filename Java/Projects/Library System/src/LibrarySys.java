import java.util.Scanner;
import java.util.*;
// import java.util.Collections;

class Books{
/
    String bookTitle;
    String bookAuthor;
    String bookId;
    
    // first [] = book names
    // second [] = book authors
    String[][] fromLibrary;
    
    Books(){
        this.bookTitle = "";
        this.bookAuthor  = "";
                            // Book Names ,   Book Authors
        this.fromLibrary  = {{"Don Quixote", "Miguel de Cervantes"},
                             {"Alice's Adventures in Wonderland", "Lewis Carroll"},
                             {"he Adventures of Huckleberry Finn", "Mark Twain"},
                             {"he Adventures of Tom Sawyer", "Mark Twain"},
                             {"Treasure Island", "Robert Louis Stevenson"},
                             {"Pride and Prejudice", "Jane Austen"},
                             {"Wuthering Heights", "Emily Brontë"},
        };
    }
    
    void displayListBooks(){
        for(byte i = 0; i < fromLibrary[i].length; i++){
            System.out.printf("Book no. %d: \nBook Name: %s\nAuthor: %s\n\n", i+1, fromLibrary[i][0], fromLibrary[1][0]);
            
        }
    }
    

    
    
}
 
class Library {
    Books books = new Books();
    ArrayList<ArrayList<String>> bookFromLibrary = new ArrayList<ArrayList<String>>();
    
    ArrayList<String> bookName = new ArrayList<String>();
    ArrayList<String> bookAuthor = new ArrayList<String>();



/*    void displayListBooks(ArrayList<ArrayList<String>> book){
        for(byte i = 0; i <)
    }
    */
        

    
    
    
    
    ArrayList<ArrayList<String>> bookFromUser = new ArrayList<ArrayList<String>>();
        
    ArrayList<ArrayList<String>> listOfBooks = new ArrayList<ArrayList<String>>();
    
}

class Records{
    
}

class Main {
    static Library library = new Library();
    static Scanner in = new Scanner(System.in);
    public static void main (String[] args) {
        
        
        
    }
}