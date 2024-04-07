

public class ObjectPassing {
    public static void main(String[] args){

        Student studentOne = new Student("Jacinth", "BSIT", "Computer Programming 12");
        Student studentTwo = new Student("John", "BSIT", "Computer Programming 12");
        Student studentThree = new Student("Lance", "BSIT", "Computer Programming 12");
        Student studentFour = new Student("Earl", "BSIT", "Computer Programming 12");
        Student studentFive = new Student("Kent", "BSIT", "Computer Programming 12");

        Classroom room = new Classroom();

        room.currentClass(studentOne);
        room.currentClass(studentTwo);
        room.currentClass(studentThree);
        room.currentClass(studentFour);
        room.currentClass(studentFive);

        Student.studentsInClass();

    }
}
class Student{

    String name;
    String course;
    String subject;

    static int numOfStudents;

    Student(String name, String course, String subject){
        this.name = name;
        this.course = course;
        this.subject = subject;
        numOfStudents++;
    }

    static void studentsInClass(){
        System.out.printf("\nYou currently have %d in your class\n", numOfStudents);
    }
    


}
class Classroom{

    void currentClass(Student student){
        System.out.printf("\n%s in %s, is currently in class, the subject is %s\n", student.name, student.course, student.subject);

    }




}

