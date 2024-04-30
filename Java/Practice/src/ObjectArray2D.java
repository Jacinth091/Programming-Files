import java.util.Scanner;
class ObjectArray2D{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int noOfSections = 2, noOfStud = 3;

        Student[][] students = new Student[noOfSections][noOfStud];

        for(int i =0; i< noOfSections; i++){
    
            System.out.printf("\nSection no. %d\n\n", (i+1));
            for(int j = 0; j < noOfStud; j++){
                System.out.print("Enter Student Name: ");
                String name = in.nextLine();
                System.out.print("Enter Student Average: ");
                int average = in.nextInt();
                in.nextLine();

                students[i][j] = new Student(name, average);

            }
        }
        for(int i =0; i< noOfSections; i++){
            System.out.printf("\nSection no. %d\n\n", (i+1));
            for(int j = 0; j < noOfStud; j++){
                System.out.printf("\nStudent %d:", (j+1));
                System.out.printf("\nName: %s\n", students[i][j].getName());
                System.out.printf("Average: %d\n", students[i][j].getAverage());


            }
        }


    }
}
class Student{
    String name;
    int aver;

    Student(String name, int aver){
        this.setName(name);
        this.setAver(aver);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAver(int aver){
        this.aver = aver;
    }

    public String getName(){
        return this.name;
    }

    public int getAverage(){
        return this.aver;
    }
}
