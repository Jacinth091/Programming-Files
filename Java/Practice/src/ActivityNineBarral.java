import java.util.Scanner;
import java.util.Arrays;
class ActivityNineBarral{

    public static void main(String[] args){

        Student[] students;
        int numOfStudents, numOfGrades;
        String studentName;
        int[] userInGrades;

        Scanner in = new Scanner(System.in);

        System.out.print("\nHow many students: ");
        numOfStudents = in.nextInt();
        in.nextLine();

        System.out.print("\nHow many grades per student: ");
        numOfGrades = in.nextInt();
        in.nextLine();
        userInGrades = new int[numOfGrades];


        students = new Student[numOfStudents];

        for(int i =0; i < numOfStudents; i++){
            System.out.printf("\nName of Student: ", (i+1));
            studentName = in.nextLine();

            for(int j = 0; j < numOfGrades; j++){
                System.out.printf("Enter grade #%d: ", (j+1));
                userInGrades[j] = in.nextInt();
                in.nextLine();
            }
            students[i] = new Student(studentName, userInGrades);
        }
        System.out.println("\n");
        // for(int i =0; i < numOfStudents; i++){
        //     System.out.printf("Student Name %d: %s \n", (i+1), students[i].studentName);
        //     System.out.println();
        //     for(int j = 0; j < students[i].studentGrades.length; j++){
        //         System.out.printf("%s's, grades: %d\n", students[i].studentName ,students[i].studentGrades[j]);

        //     }
        // }

        System.out.println("\nStudents sorted from highest average to lowest\n");
        // Arrays.sort(students);
        sortAve(students);
        for(int i =0; i < numOfStudents; i++){
            System.out.printf("Name: %s\tAverage: %.2f  Min: %d\n", students[i].studentName, students[i].getAverage(), students[i].getMinGrade() );
            
        }
        
        in.close();






    }
    static void sortAve(Student[] students){
        Student[] tempObj = new Student[1];
        for(int i = 0; i < students.length ; i++){

            for(int j = 0; j < students.length; j++){
                if(students[i].getAverage() > students[j].getAverage()){
                    tempObj[i] = students[i];
                    students[i] = students[j];
                    students[j] = tempObj[i];
                }
            }
        }


    }
}
class Student{
    String studentName;
    int[] studentGrades;

    Student(String name, int[] grades){
        studentName = name;
        studentGrades = grades;

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
