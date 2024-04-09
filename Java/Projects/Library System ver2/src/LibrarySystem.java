import java.util.Scanner;
import java.util.List;

public class LibrarySystem {
    static Scanner in = new Scanner(System.in);
    static Library library = new Library();
    static int userIn;

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
        String[] menu = {"View Book List", "Order Book/s", "Book-Cart", "Checkout Book/s", "Exit"};
        String[] viewBookMenu = {"Book List", "User Added Book List", "Back to Menu"};
        String[] orderBookMenu = {"Add to List", "Remove from List", "Back to Menu"};

        library.initializeBook(); // initialize the library with lists of books

        boolean exitLoop = false;


        do {
            System.out.print("\n**************** Menu ****************");
            dispList(menu);
            userIn = getValidIn(menu, "Menu");
            System.out.print("**************************************\n\n");


            switch (userIn) {
                case 1:
                    viewLibrary(viewBookMenu, "View Book List");

                    break;
                case 2:
                    System.out.println("Order");

                    break;
                case 3:
                    System.out.println("Book-Cart");

                    break;
                case 4:
                    System.out.println("Checkout");

                    break;
                case 0:
                    System.out.println("Exiting......");
                    System.exit(0);

                    break;
                default:
                    continue;
            }
//            break;

        } while (!exitLoop);

    }

    static void dispList(String[] array) {
        int length = array.length;
        System.out.println();
        for (int i = 0; i < length; i++) {
            if (array[i] == "Exit" || array[i] == "Back to Menu") {
                System.out.printf("\n%d. %s\n", i - (length - 1), array[i]);
            } else {
                System.out.printf("%d. %s\n", (i + 1), array[i]);
            }
        }
    }

    static int getValidIn(String[] array, String title) {
        int userIn = -1;
        boolean isValid = false;
        int length = array.length -1;

        do {
            System.out.print("Your choice: ");
            if (in.hasNextInt()) {
                userIn = in.nextInt();
                in.nextLine();
                if (userIn <= length && userIn >= 0) {
                    isValid = true;
                } else {
//                    System.out.print("**************************************\n");
                    System.out.print("\nOut of Range, try again!\n");
                    System.out.printf("\n**************** %s ****************", title);
                    dispList(array);
                    continue;
                }
            } else {
                System.out.print("\nInvalid Input, try again!\n");
                System.out.printf("\n**************** %s ****************", title);
                dispList(array);
                in.nextLine();
                continue;
            }

        } while (!isValid);


        return userIn;
    }

    static void viewLibrary(String[] array, String title){

        boolean isValid = false;

        do{
            System.out.printf("**************** %s ****************\n", title);
            dispList(array);
            userIn = getValidIn(array, title);
//            System.out.print("**************************************************\n\n");


            switch(userIn){
                case 1:
//                    System.out.println("\nLibrary: Book List\n");
                    System.out.printf("\n**************** Book List ****************\n");
                    library.displayBooks();
//                    System.out.print("\n*******************************************");
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
    static void getBookFromList(){

    }



}


