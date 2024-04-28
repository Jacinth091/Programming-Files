import java.util.Scanner;
public class Objects2DArray {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        StudentInfo[] students;

        String[] mainMenu = {"Enter Student Data", "Display Dean's List", "Display Total Number of Students", "Exit"};

        int choice;
        boolean exitLoop = false;

        do{
            System.out.print("\n***************************************************************\n");
            System.out.printf("%-15s  %s\n", " ", "Objects 2-Dimensional Arrays");
            System.out.printf("%17s  %s\n", " ", "Barral, Jacinth Cedric C.");
            System.out.print("***************************************************************\n");

            displayArray(mainMenu);
            choice = getUserChoice(mainMenu, in);

            switch(choice){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 0:
                    exitLoop = true;
                    break;
            }

        }while(!exitLoop);


    }


    static int getUserChoice(String[] array, Scanner in){
        int min = 0, max = array.length -1;
        int choice;

        do{
            System.out.print("Your Choice: ");
            choice = getValidInput(min,max,in);

            if(choice == -1){
                System.out.print("\n***************************************************************\n");
                System.out.printf("%-15s  %s\n", " ", "Invalid Input, try again!");
                System.out.print("***************************************************************\n");
                displayArray(array);

            }
            else if(choice == -2){

                System.out.print("\n***************************************************************\n");
                System.out.printf("%-15s  %s\n", " ", "Out of Range, try again!");
                System.out.print("***************************************************************\n");
                displayArray(array);
            }
            else{
                break;
            }
        }while(true);

        return choice;
    }

    static int getValidInput(int min, int max, Scanner in){
        int input = 0;

        if(in.hasNextInt()){
            int temp = in.nextInt();
            if(temp >= min && temp <= max){
                input = temp;
            }
            else{
                // indicates an out of range Error!
                input = -2;
            }
        }
        else{
            // indicates an Illegal Type Input error!
            input = -1;
        }
        in.nextLine();
        return input;
    }

    static void displayArray(String[] array){
        int arrLen = array.length;
        for(byte i = 0; i < arrLen; i++){
            if(!array[i].equals("Exit")){
                System.out.printf("%-1d. %s\n", (i+1), array[i]);
            }
            else{
                System.out.println();
                System.out.printf("%-1d. %s\n", (arrLen - i) - 1, array[i]);
            }
        }

    }

}
    
    

