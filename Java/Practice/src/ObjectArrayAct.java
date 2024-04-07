/*
Name: Barral, Jacinth Cedric C.
Date: April 5, 2024
Description: Create a Java program that accepts the names and grades of three(3) students, 
            computes the average grade for each student, 
            display the lowest grade for each student and sort 
            the students according to the highest average grade to the lowest.
*/
import java.util.Scanner;

public class ObjectArrayAct {
    static Scanner in = new Scanner(System.in);
    static int getUserIn(int min, int max, String question){
        int userIn;
        do{
            System.out.printf("%s: ", question);
            if(in.hasNextInt()){
                userIn = in.nextInt();
                in.nextLine();

                if(userIn < min || userIn > max){
                    System.out.printf("\nInput value within %d - %d, only!\n\n", min, max);
                    continue;
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("\nInvalid Input, try again!\n");
                in.nextLine();
                continue;
            }

        }while(true);
        return userIn;
    }
    static void getStudentData(Student[] students, int numOfStudents, int numOfGrades, int min, int max){
        float studGrade;
        String studName;
        for(int i =0; i < numOfStudents; i++){
            System.out.printf("\n\tStudent Number #%d\n", (i+1));
            System.out.print("\nName of Student: ");
            studName = in.nextLine();

            // Checks if the user haven't input a name
            if(studName.isEmpty()){
                System.out.println("\nYou need to input a name, try again!\n");
                i--;
                continue;
            }// Checks if the user only inputted ONE character
            else if(studName.length() == 1){
                System.out.println("\nEnter a valid name with atleast 2 or more characters, try again!\n");
                i--;
                continue;
            }// Checks if the user inputted a numeric value
            else if(checkStrForNum(studName)){
                System.out.println("\nNumeric Values are not allowed, try again!\n");
                i--;
                continue;
            }
            // Get Students Name then pass it through 
            students[i] = new Student(studName);
            // Initialize the size of the studentGrades[] in students[] using numOfGrades
            students[i].studentGrades = new float[numOfGrades];

            for(int j =0; j < numOfGrades; j++){
                System.out.printf("Enter grades #%d: ", (j+1));
                if(in.hasNextFloat()){
                    studGrade = in.nextFloat();
                    in.nextLine();

                    if(studGrade < min || studGrade > max){
                        System.out.printf("\nInput grades within %d - %d, only!\n\n", min,max);
                        j--;
                        continue;
                    }
                    else{
                        students[i].studentGrades[j] = studGrade;
                    }
                }
                else{
                    System.out.println("\nInvalid Input!, try again.\n");
                    in.nextLine();
                    j--;
                    continue;
                }
            }
        }
    }
    static void sortByAve(Student[] students){
        Student temp;
        for(int i = 0; i < students.length - 1; i++){
            for(int j =  i +1; j < students.length; j++){
                if(students[i].getAverage() < students[j].getAverage()){
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
    static void displayArray(Student[] students){
        for(int i =0; i < students.length; i++){
            System.out.printf("Name : %-15s", students[i].studentName);
            System.out.printf("Average: %-7.2f", students[i].getAverage());
            System.out.printf("Min: %-5d", students[i].getMinGrade());
            System.out.printf("Max: %-5d\n", students[i].getMaxGrade());

        }
    }
    static boolean askUserYesOrNo(){
        char ch;
        boolean boolFlag = false;
        do{
            System.out.print("\nDo you want to try again? (Y = Yes, N = No): ");
            ch = in.next().charAt(0);
            ch = Character.toUpperCase(ch);
            in.nextLine();

            if(ch != 'N' && ch != 'Y'){
                System.out.println("\nEnter a valid input, try again!\n");
                continue;
            }
            else if(ch == 'N'){
                System.out.println("\nThanks for using the program, Goodbye! :D\n");
                boolFlag = true;
                break;
            }
            else{
                System.out.println();
                break;
            }
        }while(true);
        return boolFlag;
    }
    static boolean checkStrForNum(String strToCheck){
        boolean isNumeric = false;
        for(char ch : strToCheck.toCharArray()){
            if(Character.isDigit(ch)){
                isNumeric= true;
                break;
            }
        }
        return isNumeric;
    }
    
    public static void main(String[] args) {
        Student[] students;
        int numOfStudents, numOfGrades, attempt = 1;
        boolean exitLoop =false;
        
        do{
            System.out.printf("Attempt/s: %d\n", attempt);
            System.out.println("********************** Student Records **********************\n");

            // Get user input for Number of Students
            numOfStudents = getUserIn(1, 10, "Enter Number of Students");
            
            //Declare the size of the Students[] using numOfStudents variable
            students = new Student[numOfStudents];

            // Get user input for Number of Grades per Student
            numOfGrades = getUserIn(1, 100, "Enter Number of Grades per Students");
            
            // Getting the Name of the Students as well as their grades based on the number of grades
            getStudentData(students, numOfStudents, numOfGrades, 50, 100);
    
            // Sort the Students[] using thier computed average
            sortByAve(students);
    
            System.out.println("\n\nStudents sorted from highest average to lowest:\n");
            // Display the new order of students inside the Student[] 
            displayArray(students);
            System.out.println("\n*************************************************************");

            // Asks user to input Y for Yes, N for No to loop back to the program
            exitLoop = askUserYesOrNo();
            // Add a plus one to the current attempt
            attempt++;

        }while(!exitLoop);

        in.close();
    }   

}

class Student{

    String studentName;
    float[] studentGrades;

    Student(String name){
        studentName = name;
    }

    float getAverage(){
        float sum = 0;
        for(int i = 0; i < studentGrades.length; i++){
            sum += studentGrades[i];
        }
        return sum/studentGrades.length;
    }
    int getMinGrade(){
        int min = 100;
        for(byte i =0; i<studentGrades.length; i++){
            if(min > studentGrades[i]){
                min = (int)studentGrades[i];
            }
        }
        return min;
    }
    int getMaxGrade(){
        int max = 0;
        for(byte i =0; i<studentGrades.length; i++){
            if(max < studentGrades[i]){
                max = (int)studentGrades[i];
            }
        }
        return max;
    }
}