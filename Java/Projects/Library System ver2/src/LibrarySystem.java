import java.util.Scanner;

public class LibrarySystem {
    static Scanner in = new Scanner(System.in);
    static Library library = new Library();
    static int userIn, length =0;
    static  boolean isValid = false;

    public static void main(String[] args) {
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
            switch(userIn){
                case 1: // Displays User Ordered Book List
                    if(library.userBookCart.isEmpty()){
                        System.out.print("\n---------------------------------------------------------------\n");
                        System.out.printf("\t\t\t   %s\n", "Your Books List is currently EMPTY!");
                        System.out.printf("\t\t\t\t   %s\n", "Add Books to List first");
                        System.out.print("---------------------------------------------------------------\n");
                    }else{
                        library.dispUserBookList(library.userBookCart);
                    }
                    continue;
                case 2:
//                    System.out.println("Get Data from List\n");
                    library.displayBooks(2);

                    // Get Book Number from List
                    userIn = library.getBookNumber(in, library.bookList, "order");
                    if(userIn == 0){
                        continue;
                    }
                    else{
                        // Get Book from Book List using the Book Number
                        orderedBook = library.getBookFromList(userIn, library.bookList);
                        // checks if the book Status if "Available" or "Not Available"
                        if(!library.checkBookStatus(orderedBook, library.bookList)){
                            System.out.print("\n---------------------------------------------------------------\n");
                            System.out.printf("\t\t\t   %s\n", "The Book is Currently Not Available");
                            System.out.printf("\t\t\t\t   %s\n", "Check your order list");
                            System.out.print("---------------------------------------------------------------\n");
                            continue;
                        }

                        // checks if the user confirm order, add to list
                        if(dispSuccess(orderedBook, "ORDER")){
                            // Add Book to Ordered Book List
                            library.optToOrderList(orderedBook, true);
                            // set status to ordered Book Data to False == Not Available
                            library.setBookToFalse(userIn, library.bookList);

                        }// if not confirmed, loop back at the menu
                        else{
                            continue;
                        }

                        // Display Current Ordered Book List
                        library.dispUserBookList(library.userBookCart);
                    }



                    continue;
                case 3:
//                    System.out.println("Remove Books\n");
                    // Check if list has data
                        // if list has no data, continue to loop
                    if(library.userBookCart.isEmpty()){
                        System.out.print("\n---------------------------------------------------------------\n");
                        System.out.printf("\t\t\t   %s\n", "Your Books List is currently EMPTY!");
                        System.out.printf("\t\t\t\t   %s\n", "Add Books to List first");
                        System.out.print("---------------------------------------------------------------\n");
                    }
                    // if list has data, perform removing
                    else{
                        // Get current data list
                        library.dispUserBookList(library.userBookCart);
                        // Get Book Number from List, using user input
                        userIn = library.getBookNumber(in, library.userBookCart, "remove");
                        if(userIn == 0)
                            continue;
                        else{
                            // Get Book from Book List using the Book Number
                            orderedBook = library.getBookFromList(userIn, library.userBookCart);
                            if(dispSuccess(orderedBook, "REMOVE")){
                                // Remove Book from List
                                library.optToOrderList(orderedBook, false);
                                library.setBookToTrue(library.bookList,orderedBook);

                            }
                            else{
                                continue;
                            }
                            // Display Current Ordered Book List
                            library.dispUserBookList(library.userBookCart);
                        }
                    }
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
    static boolean dispSuccess(BookData orderedBook, String option){
        boolean flagValue;
        System.out.printf("\n%s --> %s by %s? \n", option, orderedBook.bookTitle, orderedBook.bookAuthor);
        if(askConfirm()){
            System.out.print("\n---------------------------------------------------------------\n");
            System.out.printf("\t\t\t\t\t   %s COMPLETED\n", option);
            System.out.print("---------------------------------------------------------------\n");

            return true;
        }
        else{
            System.out.print("\n---------------------------------------------------------------\n");
            System.out.printf("\t\t\t\t\t   %s FAILED\n", option);
            System.out.print("---------------------------------------------------------------\n");
            return false;
        }

    }

}


