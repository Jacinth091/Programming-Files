/*
 Name: Barral, Jacinth Cedric c.
 Date: May 2, 2024
 Description: Creating a Student Class with Grades using 2d Arrays
 */


import java.util.Scanner;
class ActEleven{
    public static void main(String[] args){

        int noOfSections = 2, noOfStudents = 3;
        double studAve = 0;

        Student[][] students  = new Student[noOfSections][noOfStudents];
        String[] sec = {"BSIT", "Comp Sci"};

        String[][] name = {
        {"Amanda", "Nicole", "Arthur" }, 
        {"Steve", "Wanda", "Jarvis"}};


        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                students[i][j] = new Student(name[i][j]);
            }
        }

        students[0][0].studGrades = new int[]{80,81,82};
        students[0][1].studGrades = new int[]{93,89,84};
        students[0][2].studGrades = new int[]{79,85,81};

        students[1][0].studGrades = new int[]{92,85,88};
        students[1][1].studGrades = new int[]{89,96,91};
        students[1][2].studGrades = new int[]{82,89,85};
        

        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                studAve = students[i][j].computeAverage(students[i][j].studGrades);
                students[i][j].setAverage(studAve);
            }
        }


        System.out.print("Array contents before sorting students by section.");
        displayArray(students, sec);

        arrangeBySection(students, noOfSections, noOfStudents);
        System.out.print("\nArray contents after sorting students by section.");
        displayArray(students, sec);

        arrangeByTopStudents(students, sec);
        System.out.print("\nArray contents after sorting by rows on top per section.");
        displayArray(students, sec);



    }

    static void displayArray(Student[][] studAr, String[] sec)
    {
       System.out.println();
       for (int x=0; x<studAr.length; x++)
       {
          System.out.printf("%-15s => ",sec[x]);
          
          for(int y=0; y<studAr[0].length; y++)
          {
            System.out.printf("%-10s(%.2f)  ||  ",studAr[x][y].getName(),studAr[x][y].getAverage());
          }
          System.out.println();
       }  
    }
    static void arrangeBySection(Student[][] students, int noOfSections, int noOfStudents){
        for (int k=0; k<noOfSections; k++)
        {
            for (int i=0; i<noOfStudents-1; i++)
            {
                for (int j=i+1; j<noOfStudents; j++)
                {
                    if (students[k][i].studAverage < students[k][j].studAverage)
                    {
                        Student temp = students[k][i];
                        students[k][i] = students[k][j];
                        students[k][j] = temp;
                   }
                }
            }   
        }
    }
    static void arrangeByTopStudents(Student[][] students, String[] sections ){
        for(int i=0; i<students.length-1; i++)
         for (int j=i+1; j<students.length; j++)
            if (students[i][0].studAverage < students[j][0].studAverage)
            {
               Student[] temp = students[i];
               students[i] = students[j];
               students[j] = temp;
               
               String tmpSect = sections[i];
               sections[i] = sections[j];
               sections[j] = tmpSect;
            }
      
    }
}

class Student{
    String studName;
    int[] studGrades;
    double studAverage;

    Student(String name){
        this.setName(name);
    }


    public void setName(String name){
        this.studName = name;
    }
    public String getName(){
        return this.studName;
    }


    public void setAverage(double average){
        this.studAverage = average;
    }

    public double getAverage(){
        return this.studAverage;
    }


    public double computeAverage(int[] grades){
        double average = 0;
        int total =0, counter = grades.length;
        for(int i =0; i < counter; i++){
            total += grades[i];
        }
        average = (double)total / counter;
        
        return average;
    }

}