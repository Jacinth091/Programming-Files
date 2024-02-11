import java.util.Scanner;
import java.util.ArrayList;

class userTasks{
    Scanner userInput = new Scanner(System.in);
    ArrayList<String> tasksList = new ArrayList<String>();
    int response, userGetValue;
    String[] userOptions = {"Create Tasks", "Edit Tasks", "View Tasks", "Remove/Delete Tasks" };

    void userDisplay(String[] userArray){
        System.out.println();
        System.out.println("---------------------------------------");
        for(int i = 0; i <userArray.length; i++){
            System.out.println((i + 1) + ". " + userArray[i]);
        }
        System.out.println("---------------------------------------");
        System.out.println();
    }

    void userSelect(String[] array){
        response = 0;
        userGetValue = 0;
//        boolean isDone;

        do{
            System.out.print("Enter:  ");
            response = userInput.nextInt();
            if(response <= array.length && response > 0){
                userGetValue = response;
                break;
            }
            else {
                System.out.println("Input a valid number!");
                userDisplay(userOptions);

            }

        }while(true);




    }

    void createTask(){

    }
    void editTasks(){

    }
    void viewTasks(){

    }
    void deleteTasks(){

    }











}
public class Todo_List {
    public static void main(String[] args) {
        userTasks TASKS = new userTasks();

        System.out.println("---------------- Todo List version: 1 ----------------");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("\t\t\t   Todo List:");
        System.out.println("***************************************\n");

//        System.out.println("1. Create Tasks");
//        System.out.println("2. Edit Tasks");
//        System.out.println("3. View Tasks");
//        System.out.println("4. Remove/Delete Tasks");

        // To display the items inside the array for the user to select
        TASKS.userDisplay(TASKS.userOptions);


        // To Enter a selection
        TASKS.userSelect(TASKS.userOptions);


    }
}


