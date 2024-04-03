import java.util.Scanner;
class ActivityNineBarral{

    public static void main(String[] args){

        Student[] students;
        int numOfStudents, numOfGrades;
        String studentName;
        int[] userInGrades;

        Scanner in = new Scanner(System.in);

        System.out.println("\nActivity Nine: Class Array");

        System.out.print("\nHow many students: ");
        numOfStudents = in.nextInt();
        in.nextLine();

        System.out.print("How many grades per student: ");
        numOfGrades = in.nextInt();
        in.nextLine();

        students = new Student[numOfStudents];

        System.out.println("\nEnter data:");
        for(int i =0; i < numOfStudents; i++){
            System.out.printf("\nName of Student: ", (i+1));
            studentName = in.nextLine();
            userInGrades = new int[numOfGrades];
            for(int j = 0; j < numOfGrades; j++){

                System.out.printf("Enter grade #%d: ", (j+1));
                userInGrades[j] = in.nextInt();
                in.nextLine();
            }
            students[i] = new Student(studentName, userInGrades);
        }
        System.out.println("\n");
        System.out.println("\nStudents sorted from highest average to lowest:");
        sortAve(students);
        for(int i =0; i < numOfStudents; i++){
            System.out.printf("Name: %s\tAverage: %.2f  Min: %d\n", students[i].studentName, students[i].getAverage(), students[i].getMinGrade() );  
        }
        in.close();






    }
    static void sortAve(Student[] students){
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
}
