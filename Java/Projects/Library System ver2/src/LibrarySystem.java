import java.util.Scanner;
import java.util.List;

public class LibrarySystem {
    static Scanner in = new Scanner(System.in);
    static Library library = new Library();
    static int userIn, length;
    static  boolean isValid = false;


    public static void main(String[] args) {

//        Library library =  new Library();
//        BookData books = new BookData(null,null,null,0 ,0,false);
//
//        library.initializeBook();
//        library.displayBooks();
//
//        System.out.println();
//
//        System.out.printf("\nAuthor: ");
//        for(int i =0; i <library.length; i++){
//            System.out.printf("%s  ", library.authorList.get(i));
//        }
//        System.out.printf("\nTitle: ");
//        for(int i =0; i <library.length; i++){
//            System.out.printf("%s  ", library.titleList.get(i));
//        }
//        System.out.printf("\nGenre: ");
//        for(int i =0; i <library.length; i++){
//            System.out.printf("%s  ", library.genreList.get(i));
//        }

        System.out.print("\n**************************************************\n");
        System.out.print("\t\t\t Library System ver 2");
        System.out.print("\n**************************************************\n");

        libraryMenu();


    }

    static void libraryMenu() {
        String[] menu = {"View Book List", "Order Book/s", "Add Book/s", "Checkout Book/s", "Exit"};
        String[] viewBookMenu = {"Book List", "User Added Book List", "Back to Menu"};
        String[] orderBookMenu = {"View Ordered Books", "Add to List", "Remove from List", "Back to Menu"};

        library.initializeBook(); // initialize the library with lists of books

        boolean exitLoop = false;


        do {
            System.out.print("\n**************** Menu ****************\n");
            dispList(menu);
            userIn = getValidIn(menu, "Menu");
            System.out.print("**************************************\n\n");


            switch (userIn) {
                case 1:
                    viewLibrary(viewBookMenu, "View Book List");

                    break;
                case 2:
                    System.out.println("Order");
                    orderBooks(orderBookMenu, "Order Book/s");


                    break;
                case 3:
                    System.out.println("Add Book/s");

                    break;
                case 4:
                    System.out.println("Checkout");

                    break;
                case 0:
                    System.out.println("Exiting......");
//                    System.exit(0);

                    exitLoop = true;
                    break;
                default:
                    continue;
            }
//            break;

        } while (!exitLoop);

    }

    static void dispList(String[] array) {
        int length = array.length;
//        System.out.println();
        for (int i = 0; i < length; i++) {
            if (array[i] == "Exit" || array[i] == "Back to Menu") {
                System.out.printf("\n%d. %s\n", i - (length - 1), array[i]);
            } else {
                System.out.printf("%d. %s\n", (i + 1), array[i]);
            }
        }
    }

    static int getValidIn(String[] array, String title) {
        userIn = -1;
        isValid = false;

        do{
            length = array.length -1;
            System.out.print("Your choice: ");
            if (in.hasNextInt()) {
                userIn = in.nextInt();
                in.nextLine();
                if (userIn <= length && userIn >= 0) {
                    isValid = true;
                } else {
//                    System.out.print("**************************************\n");
                    System.out.print("\nOut of Range, try again!\n");
                    System.out.printf("\n**************** %s ****************\n", title);
                    dispList(array);
                }
            } else {
                System.out.print("\nInvalid Input, try again!\n");
                System.out.printf("\n**************** %s ****************\n", title);
                dispList(array);
                in.nextLine();
            }
        }while(!isValid);

        return userIn;
    }

    static void viewLibrary(String[] array, String title){
        do{
//            System.out.println("In: " + isValid);
            System.out.printf("**************** %s ****************\n", title);
            dispList(array);
            userIn = getValidIn(array, title);
            isValid = false;


            switch(userIn){
                case 1:
                    System.out.printf("\n**************** %s ****************\n", title);
                    library.displayBooks(1); // 1 = for all book Data
                    break;
                case 2:

                    System.out.println("Users: Book List\n");
                    continue;
                case 0:

                    System.out.println("Back to Menu\n");
                    isValid = true;
                    break;
            }
        }while(!isValid);
    }

    static void orderBooks(String[] array, String title){
        BookData orderedBook;
        do{
            System.out.printf("\n**************** %s ****************\n", title);
            dispList(array);
            userIn = getValidIn(array, title);
            isValid = false;
//            System.out.println(userIn);

            switch(userIn){
                case 1: // Displays User Ordered Book List
//                    library.displayBooks(2);
                    library.dispUserBookList(library.userBookCart);

                    continue;
                case 2:
//                    System.out.println("Get Data from List\n");
                    library.displayBooks(2);

                    // Get Book Number from List
                    userIn = library.getBookNumber(in);

                    // Get Book from Book List using the Book Number
                    orderedBook = library.getBookFromList(userIn);

                    System.out.printf("\nOrder --> %s by %s? \n", orderedBook.bookTitle, orderedBook.bookAuthor);
                    if(askConfirm()){
                        System.out.print("\n---------------------------------------------------------------\n");
                        System.out.print("\t\t\t\t\t   ORDER COMPLETED\n");
                        System.out.print("---------------------------------------------------------------\n");
                        // Add Book to Ordered Book List
                        library.addBookToOrderList(orderedBook);
                    }
                    else{
                        System.out.print("\n---------------------------------------------------------------\n");
                        System.out.print("\t\t\t\t\t   ORDER FAILED\n");
                        System.out.print("---------------------------------------------------------------\n");
                        continue;
                    }

                    // Display Current Ordered Book List
                    library.dispUserBookList(library.userBookCart);


                    continue;
                case 3:
                    System.out.println("Users: Book List\n");
                    continue;
                case 0:

                    System.out.println("Back to Menu\n");
                    isValid = true;
                    break;
            }
        }while(!isValid);
    }

static boolean askConfirm(){
        boolean boolValue = false;
        isValid = false;
        char choice;

        do{
            System.out.print("Confrim Action ( Y = Yes, N = No): ");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);

            if(choice != 'Y' && choice != 'N'){
                System.out.print("\nInvalid Input, try again!\n");

            }
            else if(choice == 'Y'){
                boolValue = true;
                isValid = true;
            }
            else{
                isValid = true;
            }

        }while(!isValid);
            isValid = false;

        return boolValue;
}


}


