/*
Name: Barral, Jacinth Cedric C.
Date: April 3, 2024
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
        Scanner in = new Scanner(System.in);

        Student[] students; // create an instance of Students[] without setting the size

        System.out.println("********************** Activity Nine **********************");

        System.out.print("Number of Students: ");
        numOfStudents = in.nextInt();
        in.nextLine();

        students = new Student[numOfStudents];  // cdeclaring the size of Student[]

        System.out.print("Number of grades per Student: ");
        numOfGrades = in.nextInt();
        in.nextLine();


        for(byte i = 0; i < numOfStudents; i++){ // In regards to the numOfStudents, it will loop through until it ends
            System.out.print("\nName of Student: ");
            name = in.nextLine();

            students[i] = new Student(name); // For every name that is input is getting stored in the studentsName variable inside the Students class
            students[i].studentGrades = new int[numOfGrades];   // Declaration of the size of the studentsGrades array

            for(byte j =0; j < numOfGrades; j++){
            
                System.out.printf("Enter grades #%d: ", (j+1));
                
                studGrade = in.nextInt();
                in.nextLine();

                if(studGrade <= 0){
                    System.out.print("\nEnter grade above 0, try again\n");
                    j--;
                    continue;
                }
                else{
                    students[i].studentGrades[j] = studGrade;
                }


            }


        }
        System.out.println("\nStudents sorted from highest average to lowest:");
        sortByAve(students);
        for(int i =0; i < numOfStudents; i++){
            System.out.printf("Name: %s\tAverage: %.2f  Min: %d  Max:%d\n", students[i].studentName, students[i].getAverage(), students[i].getMinGrade(), students[i].getMaxGrade() );  
        }
        
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
