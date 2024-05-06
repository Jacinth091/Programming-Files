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

        Students[][] students  = new Students[noOfSections][noOfStudents];
        String[] sec = {"BSIT", "Comp-Sci"};
        String[] title = {"1st", "2nd", "3rd", "4th","5th","6th","7th","8th","9th","10th"};

        String[][] name = {
        {"Amanda", "Nicole", "Arthur" }, 
        {"Steve", "Wanda", "Jarvis"}};


        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                students[i][j] = new Students(name[i][j]);
                students[i][j].setSection(sec[i]);
            }

        }

        int[][] gradeData = {
                {80,81,82},
                {93,89,84},
                {79,85,81},
                {92,85,88},
                {89,96,91},
                {82,89,85}
        };

        for (int i = 0; i < noOfSections; i++) {
            for (int j = 0; j < noOfStudents; j++) {
                int[] grades = new int[gradeData[i].length];
                for (int k = 0; k < gradeData[i].length; k++) {
                    grades[k] = gradeData[i*noOfStudents+j][k];
//                    System.out.printf("%d ", grades[k]);
                }
                System.out.println();
                students[i][j].setGrade(grades);
            }
        }


//        students[0][0].studGrades = new int[]{80,81,82};
//        students[0][1].studGrades = new int[]{93,89,84};
//        students[0][2].studGrades = new int[]{79,85,81};
//
//        students[1][0].studGrades = new int[]{92,85,88};
//        students[1][1].studGrades = new int[]{89,96,91};
//        students[1][2].studGrades = new int[]{82,89,85};
        

        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                studAve = students[i][j].computeAverage(students[i][j].getGrades());
                students[i][j].setAverage(studAve);
            }
        }

        displayHeader();

        System.out.println();
//
////        System.out.print("**********************************************************************************\n");
//        System.out.print("\nArray contents before sorting students by section.");
//        displayArray(students, sec,title, false);
////        System.out.print("**********************************************************************************\n");
//
//
////        System.out.print("\n**********************************************************************************\n");
        arrangeBySection(students, noOfSections, noOfStudents);
//        System.out.print("\nArray contents after sorting students by section.");
//        displayArray(students, sec, title, true);
////        System.out.print("**********************************************************************************\n");

        arrangeForDeansList(students, sec);
        System.out.print("\nArray contents after sorting by rows on top per section.");
//        displayDeansList(students, sec, title);
//        displayArray(students, sec,title, true);
        displayArrays(students, sec);


    }

    static void displayArray(Students[][] students, String[] sec,String[] title, boolean isOrdered)
    {
       System.out.println();
       for (int i=0; i<students.length; i++)
       {
          if(!(sec[i].length() > 4)){
              System.out.printf("**************************** %s ******************************\n", sec[i]);
          }
          else{
              System.out.printf("************************** %s ****************************\n", sec[i]);
          }

           if(isOrdered){
               System.out.printf("%-15s %-25s %-10s\n----------------------------------------------------------------\n","Rank","Name of Student","Average");
           }
           else
           {
               System.out.printf("%-15s %-25s\n----------------------------------------------------------------\n","Rank","Name of Student");
           }

          for(int j=0; j<students[0].length; j++)
          {
               if(isOrdered){
                   System.out.printf("%-15s %-25s %-10.2f\n",title[j],students[i][j].getName(),students[i][j].getAverage());
               }
               else{
                   System.out.printf("%-15s %-25s\n","(*)",students[i][j].getName());

               }
          }

          System.out.println("----------------------------------------------------------------\n");
       }  
    }

    static void displayDeansList(Students[][] students, String[] sec, String[] title){
        System.out.println();
        Students temp;
        int count = 0;
        for(int i = 0; i< students.length; i++){
            for(int j = 0; j < students[i].length; j++){
                temp = students[i][j];
                System.out.printf("%-15s %-25s %-10.2f %-10s\n",title[count++],temp.getName(),temp.getAverage(), temp.getSection());


            }
//            System.out.println();
        }
    }

    static void displayArrays(Students[][] studAr, String[] sec)
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



    static void arrangeBySection(Students[][] students, int noOfSections, int noOfStudents){
        for (int k=0; k<noOfSections; k++)
        {
            for (int i=0; i<noOfStudents-1; i++)
            {
                for (int j=i+1; j<noOfStudents; j++)
                {
                    if (students[k][i].getAverage() < students[k][j].getAverage())
                    {
                        Students temp = students[k][i];
                        students[k][i] = students[k][j];
                        students[k][j] = temp;
                   }
                }
            }   
        }
    }
    static void arrangeForDeansList(Students[][] students, String[] sections ){
        for(int i=0; i<students.length-1; i++)
         for (int j=i+1; j<students.length; j++)
            if (students[i][0].getAverage() < students[j][0].getAverage())
            {
               Students[] temp = students[i];
               students[i] = students[j];
               students[j] = temp;
               
               String tmpSect = sections[i];
               sections[i] = sections[j];
               sections[j] = tmpSect;
            }
      
    }


    static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-25s  %s\n", " ", "Objects 2-Dimensional Arrays");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 11");
        System.out.print("**********************************************************************************\n");
    }


}

class Students{
    private String studName, studSection;
    private int[] studGrades;
    private double studAverage;

    Students(String name){
        this.setName(name);
    }


    public void setName(String name){
        this.studName = name;
    }
    public String getName(){
        return this.studName;
    }

    public void setSection(String section){
        this.studSection = section;
    }
    public String getSection(){
        return this.studSection;
    }


    public void setAverage(double average){
        this.studAverage = average;
    }
    public double getAverage(){
        return this.studAverage;
    }

    public void setGrade(int[] grades){
        this.studGrades = grades;
    }
    public int[] getGrades(){
        return this.studGrades;
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