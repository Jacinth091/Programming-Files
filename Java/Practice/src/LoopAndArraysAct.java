/*
 Name: Barral, Jacinth Cedric C.
 Date: March 12, 2023
 Description: Create a Java program that accepts a name of a student, accepts grades, prints the minimum, maximum and average grade of the student.
 */
import java.util.Scanner;
class LoopAndArraysAct {
    public static void main(String[] args) {
        char choice;
        Scanner in = new Scanner(System.in);
        Student student;
        do {
            student = new Student();
//            System.out.println("\n----------------Student----------------");
            System.out.print("\nName of Student: ");
            student.name = in.nextLine();
//            System.out.println("---------------------------------------");
            for (byte i = 0; i < student.grades.length; i++) {
                System.out.printf("Enter %s's grade #%d: ", student.name, (i + 1));
                student.grades[i] = in.nextInt();
            }
            in.nextLine();
/*        System.out.println();
        for(byte i = 0; i < student.grades.length; i++){
            System.out.printf("Grade: %d\n", student.grades[i]);
        }*/
//            System.out.println("------------Student Details------------");
            System.out.printf("Name of Student: %s\n", student.name);
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.printf("Min: %d\n", student.getMinGrade());
            System.out.printf("Max: %d\n\n", student.getMaxGrade());
//            System.out.println("---------------------------------------\n");

            do {
                System.out.print("Again? (Y for Yes, N for NO): ");
                choice = in.next().charAt(0);
                choice = Character.toUpperCase(choice);
                in.nextLine();
                if(choice != 'Y' && choice != 'N'){
                    System.out.println("Invalid!");
                }
            } while (choice != 'Y' && choice != 'N');
        } while (choice != 'N');
        in.close();
    }
}
class Student {
    final int arraySize = 5;
    String name;
    int[] grades = new int[arraySize];
    int minGrade = 0, maxGrade = 0;
/*    Student(){
        this.name = null;
        this.minGrade = 0;
        this.maxGrade = 0;
        this.grades = new int[arraySize];
    }*/
    float getAverage(){
        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        return (float) sum/grades.length;
    }
    int getMinGrade(){
        int min = 100;
        for(byte i =0; i<grades.length; i++){
            if(min > grades[i]){
                min = grades[i];
            }
        }
        return min;
    }
    int getMaxGrade(){
        int max = 0;
        for(byte i =0; i<grades.length; i++){
            if(max < grades[i]){
                max = grades[i];
            }
        }
        return max;
    }
}
