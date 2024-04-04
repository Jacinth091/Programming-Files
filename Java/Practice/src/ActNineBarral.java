/*
Name: Barral, Jacinth Cedric C.
Date: April 4, 2024
Description: Create a Java program that accepts the names and grades of three(3) students, 
            computes the average grade for each student, 
            display the lowest grade for each student and sort 
            the students according to the highest average grade to the lowest.
*/
import java.util.Scanner;
public class ActNineBarral {
    public static void main(String[] args) {
        
        int numOfStudents, numOfGrades, studGrade;
        String name;
        char choice;
        boolean exitLoop = false;
        Scanner in = new Scanner(System.in);
        Student[] students; // create an instance of Students[] without setting the size

        System.out.println("********************** Activity Nine **********************\n");
        int attempt =0;
        do{
            System.out.printf("\nAttempts: %d\n\n", attempt);

            do{ // Checks if value inputted (number of students) are within range 1 -10
                System.out.print("Number of Students: ");
                if(in.hasNextInt()){
                    numOfStudents = in.nextInt();
                    in.nextLine();

                    if(numOfStudents <= 0){
                        System.out.println("\nInput value above 0, try again!\n");
                        continue;
                    }
                    else if(numOfStudents > 10){
                        System.out.println("\nInput value below 10, try again!\n");
                        continue;
                    }
                    else{
                        students = new Student[numOfStudents];  // declaring the size of Student[]
                        do{// Checks if value inputted (number of grades per sudents) are within range 1-10
                            System.out.print("Number of grades per Student: ");
                            if(in.hasNextInt()){
                                numOfGrades = in.nextInt();
                                in.nextLine();

                                if(numOfGrades <= 0){
                                    System.out.println("\nInput value above 0, try again!\n");
                                    continue;
                                }
                                else if(numOfGrades > 10){
                                    System.out.println("\nInput value below 10, try again!\n");
                                    continue;
                                    
                                }
                                else{
                                    // If the number of grade per student is valid, break out of the do-while Loop
                                    break;
                                }
                            }
                            else{ // If the inputted value is not a type Int value, it will loop back
                                System.out.println("\nInvalid Input, try again!\n");
                                in.nextLine();
                                continue;
                            }
                        }while(true);
                        // If the number of student is valid, break out of the do-while Loop
                        break;
                    }
                }
                else{ // If the inputted value is not a type Int value, it will loop back
                    System.out.println("\nInvalid Input, try again!\n");
                    in.nextLine();
                    continue;
                }
            }while(true);
    
    
            // Loop through the entire size of the Students array.
            for(byte i = 0; i < numOfStudents; i++){ // In regards to the numOfStudents, it will loop through until it ends
                System.out.printf("\n\tStudent Number #%d\n", (i+1));
                System.out.print("\nName of Student: ");
                name = in.nextLine();
    
                System.out.println();
    
                students[i] = new Student(name); // For every name that is input is getting stored in the studentsName variable inside the Students class
                students[i].studentGrades = new int[numOfGrades];   // Declaration of the size of the studentsGrades array
    
                for(byte j =0; j < numOfGrades; j++){
                
                    System.out.printf("Enter grades #%d: ", (j+1));
                    if(in.hasNextInt()){
                        studGrade = in.nextInt();
                        in.nextLine();
            
                        if(studGrade <= 0){ // If grade is below or equal to zero, ask the user again 
                            System.out.print("\nEnter grade above 0, try again\n");
                            j--;
                            continue;
                        }
                        else if(studGrade > 100){// If grade is above 100, ask the user again 
                            System.out.print("\nEnter only grades that are below 100, try again\n");
                            j--;
                            continue;
                        }
                        else{
                            // It implies that is the input grade is within range, 1 -100 it will add it to the grades array
                            students[i].studentGrades[j] = studGrade;
                        }
                    }
                    else{
                        System.out.println("\nInvalid Grade Input, try again!\n");
                        in.nextLine();
                        j--;
                        continue;
                    }

                }
            }
            System.out.println("\n\nStudents sorted from highest average to lowest:");
            sortByAve(students);
            for(int i =0; i < numOfStudents; i++){
                System.out.printf("Name : %-15s", students[i].studentName);
                System.out.printf("Average: %-7.2f", students[i].getAverage());
                System.out.printf("Min: %-5d", students[i].getMinGrade());
                System.out.printf("Max: %-5d\n", students[i].getMaxGrade());
            }
            System.out.println();
            do{// Asks the user if he'she will exit the program or not
                System.out.print("Do you want to try again? (Y = Yes, N = No): ");
                choice = in.next().charAt(0);
                choice = Character.toUpperCase(choice);
                in.nextLine();

                if(choice != 'N' && choice != 'Y'){
                    System.out.println("\nEnter a valid input, try again!\n");
                    continue;
                }
                else if(choice == 'N'){
                    System.out.println("\nThanks for using the program, Goodbye! :D\n");
                    exitLoop = true;
                    break;
                }
                else{
                    System.out.println("\nProceed!\n");
                    break;
                }
            }while(true);
            attempt++;

        }while(!exitLoop);
        in.close();
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
}
class Student{
    String studentName;
    int[] studentGrades;

    Student(String name){
        studentName = name;
    }
    float getAverage(){
        int sum = 0;
        for(int i = 0; i < studentGrades.length; i++){
            sum += studentGrades[i];
        }
        return (float) sum/studentGrades.length;
    }
    int getMinGrade(){
        int min = 100;
        for(byte i =0; i<studentGrades.length; i++){
            if(min > studentGrades[i]){
                min = studentGrades[i];
            }
        }
        return min;
    }
    int getMaxGrade(){
        int max = 0;
        for(byte i =0; i<studentGrades.length; i++){
            if(max < studentGrades[i]){
                max = studentGrades[i];
            }
        }
        return max;
    }
}
