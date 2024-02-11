import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class userTasks{
    Scanner userInput = new Scanner(System.in);
    ArrayList<String> tasksList = new ArrayList<String>();
    int response, userGetValue;
    static int maxSize = 5;
    String userResponse;
    String defaultBuffer = "--------------------";
    String[] userOptions = {"Create Tasks", "Edit Tasks", "View Tasks", "Remove/Delete Tasks" };
    boolean validInput;

    void defaultArrList(){
        for(int i = 0; i < maxSize; i++){
            tasksList.add(i, "--------------------");
        }

    }

    void userDisplay(String[] userArray){
        System.out.println("Enter the # to interact:");
        System.out.println("---------------------------------------");
        for(int i = 0; i <userArray.length; i++){
            System.out.println((i + 1) + ". " + userArray[i]);
        }
        System.out.println();
        System.out.println("--------- 0. EXIT ---------");
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
            userInput.nextLine();
            if(response <= array.length && response >= 0){
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
        response = 0;
        userResponse = "";
        validInput = false;
        System.out.println("\n-----------------------------------");
        System.out.println("\t\t   Create Task");
        System.out.println("-----------------------------------");

        viewTasks();

        System.out.println("------------ Enter task no.  ------------");
        System.out.println();
        do {
            try{
                System.out.print("Enter task #: ");
                response = userInput.nextInt();
                userInput.nextLine();
                if(response > 0 && response <= tasksList.size()) {
                    if( tasksList.get((response - 1)).equals(defaultBuffer)){
                        System.out.println("Enter task: ");
                        userResponse = userInput.nextLine();
                        userResponse = userResponse.trim();
                        System.out.println();
                        tasksList.set((response - 1), userResponse);
                    }
                    else{
                        System.out.println("---------- You must free some tasks! ----------");
                        System.out.println();
                        userInteraction();
                    }
                    validInput = true;
                }
                else{
                    System.out.println("Invalid input! Try Again");
                }

            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Try Again");
                userInput.nextLine();
            }


        }while(!validInput);
        updateTaskList();




    }
    void editTasks(){
        response = 0;
        userResponse = "";
        validInput = false;
        System.out.println("\n-----------------------------------");
        System.out.println("\t\t   Edit Task");
        System.out.println("-----------------------------------");
        System.out.println();

        viewTasks();
        boolean allTasksEmpty = tasksList.stream().allMatch(task -> task.equals(defaultBuffer));

        if (allTasksEmpty) {
            System.out.println("-------------- All tasks are empty! --------------");
            System.out.println();
            userInteraction();
            return;
        }
        System.out.println("------------ TASK no. you want to edit ------------");
        System.out.println();
        do {
            try {
                System.out.print("Enter task #: ");
                response = userInput.nextInt();
                userInput.nextLine();
                System.out.println();
                if(response > 0 && response <= tasksList.size()) {
                    if( tasksList.get((response - 1)).equals(defaultBuffer)){
                        System.out.println("---------- This task is Empty! ----------");
                        System.out.println();
                        continue;
                    }
                    else{
                        System.out.println("Enter new task: ");
                        userResponse = userInput.nextLine();
                        userResponse = userResponse.trim();
                        System.out.println();
                        tasksList.set((response - 1), userResponse);

                    }
                    validInput = true;
                }
                else{
                    System.out.println("Invalid input! Try Again");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input! Try Again");
                userInput.nextLine();
            }



        }while(!validInput);
        updateTaskList();
    }


    void viewTasks(){
        for(int i = 0; i < tasksList.size(); i++){
            System.out.println( "\t" + (i + 1) + ". " + tasksList.get(i));
        }
        System.out.println();
    }
    void deleteTasks(){
        response = 0;
        userResponse = "";
        validInput = false;
        System.out.println("\n-----------------------------------");
        System.out.println("\t\t   Delete Task");
        System.out.println("-----------------------------------");
        System.out.println();

        viewTasks();
        boolean allTasksEmpty = tasksList.stream().allMatch(task -> task.equals(defaultBuffer));

        if (allTasksEmpty) {
            System.out.println("-------------- All tasks are empty! --------------");
            System.out.println();
            userInteraction();
            return;
        }
        System.out.println("------------ TASK no. you want to DELETE ------------");
        System.out.println();
        do {
            try {
                System.out.print("Enter task #: ");
                response = userInput.nextInt();
                userInput.nextLine();
                System.out.println();
                if(response > 0 && response <= tasksList.size()) {
                    if( tasksList.get((response - 1)).equals(defaultBuffer)){
                        System.out.println("---------- This task is Empty! ----------");
                        System.out.println();
                        continue;

                    }
                    else{
                        System.out.println("Deleting \"" + tasksList.get((response - 1)) + "\" ");
                        System.out.println();
//                    tasksList.remove((response - 1));
                        tasksList.set((response -1), defaultBuffer);

                    }
                    validInput = true;
                }
                else{
                    System.out.println("Invalid input! Try Again");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input! Try Again");
                userInput.nextLine();
            }


        }while(!validInput);
        updateTaskList();




    }

    void updateTaskList(){
        System.out.println("-----------------------------------");
        System.out.println("\t\t Updated Task List");
        System.out.println("-----------------------------------");
        viewTasks();
        System.out.println("------------------- Task Updated! -------------------");
        System.out.println();
        userInteraction();
    }
    void determineOption(){
        switch(userGetValue){
            case 1:
                createTask();
                break;
            case 2:
                editTasks();
                break;
            case 3:
                System.out.println("\n-----------------------------------");
                System.out.println("\t\t   Current Tasks");
                System.out.println("-----------------------------------");
                System.out.println();
                viewTasks();
                System.out.println();
                userInteraction();
                break;
            case 4:
                deleteTasks();
                break;
            case 0:
                System.out.println("Thank you!. Goodbye!");
                System.exit(0);
                break;
        }
    }
    void userInteraction(){
        // To display the items inside the array for the user to select
        userDisplay(userOptions);
        // To Enter a selection
        userSelect(userOptions);
        determineOption();
    }

}










public class Todo_List {
    public static void main(String[] args) {

        userTasks TASKS = new userTasks();
        TASKS.defaultArrList();

        System.out.println("---------------- Todo List version: 1 ----------------");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("\t\t    Task List Manager");
        System.out.println("***************************************");

        TASKS.userInteraction();









    }
}


