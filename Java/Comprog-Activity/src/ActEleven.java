/*
 Name: Barral, Jacinth Cedric c.
 Date: May 2, 2024
 Description: Creating a Student Class with Grades using 2d Arrays
 */
class ActEleven{
    public static void main(String[] args){

        int noOfSections = 2, noOfStudents = 3;

        Students[][] students  = new Students[noOfSections][noOfStudents];
        Students[] topStudents;
        String[] sec = {"BSIT - 1B", "BSIT - 1A"};
        String[] title = {"1st", "2nd", "3rd", "4th","5th","6th","7th","8th","9th","10th"};

        String[][] name = {
        {"Amanda", "Nicole", "Arthur" }, 
        {"Steve", "Wanda", "Jarvis"}};

        int[][] gradeData = {
                {80,81,82},
                {93,89,84},
                {79,85,81},
                {92,85,88},
                {89,96,91},
                {82,89,85}
        };
        // Setting the HardCoded Data to the 2d Students Class Array
        for (int i = 0; i < noOfSections; i++) {
            for (int j = 0; j < noOfStudents; j++) {
                // Getting grades data buffer
                int[] grades = new int[gradeData[i].length];

                for (int k = 0; k < gradeData[i].length; k++) {
                    // setting student's grade from 2d gradeData Array
                    grades[k] = gradeData[ i * noOfStudents + j][k];
                }
                // Passing and Setting the student's name, section and grade through the Students constructor
                students[i][j] = new Students(name[i][j], sec[i], grades);
            }
        }

        // Computing and Setting Student's Average
        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                // declaring and initializing and computing of average of students
                double studAve = students[i][j].computeAverage(students[i][j].getGrades());
                // Passing through the average data
                students[i][j].setAverage(studAve);
            }
        }

//        students[0][0].studGrades = new int[]{80,81,82};
//        students[0][1].studGrades = new int[]{93,89,84};
//        students[0][2].studGrades = new int[]{79,85,81};
//
//        students[1][0].studGrades = new int[]{92,85,88};
//        students[1][1].studGrades = new int[]{89,96,91};
//        students[1][2].studGrades = new int[]{82,89,85};

        displayHeader();

        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-13s  %s\n", " ", "Array contents before sorting students by section.");
        System.out.print("----------------------------------------------------------------------------------");
        displayArray(students, sec,title, false);

        arrangeBySection(students, noOfSections, noOfStudents);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-13s  %s\n", " ", "Array contents after sorting students by section.");
        System.out.print("----------------------------------------------------------------------------------");
        displayArray(students, sec, title, true);


        arrangeByRow(students, sec);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-11s  %s\n", " ", "Array contents after sorting by rows on top per section.");
        System.out.print("----------------------------------------------------------------------------------");
        displayByRow(students, sec);

        System.out.println();

        topStudents = getAllTopStudents(students, noOfSections, noOfStudents);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-20s  %s\n", " ", "All Top Students from all Sections");
        System.out.print("----------------------------------------------------------------------------------");
        displayTopStudents(topStudents, title);

    }

    // ------------------------------------------------------- DISPLAY -------------------------------------------------------
    static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-25s  %s\n", " ", "Objects 2-Dimensional Arrays");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 11");
        System.out.print("**********************************************************************************\n");
    }
    static void displayArray(Students[][] students, String[] sec,String[] title, boolean isOrdered){
        System.out.println();
       for (int i=0; i<students.length; i++)
       {

          System.out.printf("*********************************** %s ************************************\n", sec[i]);
          System.out.printf("%-25s %-35s %-20s\n","Rank","Name of Student","Average");
          System.out.println("----------------------------------------------------------------------------------");

          for(int j=0; j<students[0].length; j++)
          {
               if(isOrdered){
                   System.out.printf("%-25s %-35s %-20.2f\n",title[j],students[i][j].getName(),students[i][j].getAverage());
               }
               else{
                   System.out.printf("%-25s %-35s %-20.2f\n","(*)",students[i][j].getName(),students[i][j].getAverage());

               }
          }

          System.out.println("----------------------------------------------------------------------------------\n");
       }  
    }
    
    static void displayTopStudents(Students[] studList, String[] title){
        System.out.println();
        System.out.print("************************************** BSIT **************************************\n");
        System.out.printf("%-20s %-30s %-15s %-15s\n","Rank","Name of Student","Average", "Section");
        System.out.println("----------------------------------------------------------------------------------");
        
        for (int i=0; i<studList.length; i++)
        {

            System.out.printf("%-20s %-30s %-15.2f %-15s\n",title[i],studList[i].getName(),studList[i].getAverage(), studList[i].getSection());

        }
        System.out.println("----------------------------------------------------------------------------------\n");

    }


    static void displayByRow(Students[][] studAr, String[] sec) {
        System.out.println();
        for (int x=0; x<studAr.length; x++)
        {
            System.out.printf("%-15s => ",sec[x]);
            for(int y=0; y<studAr[0].length; y++)
            {
                if(y != studAr[0].length -1){
                    System.out.printf("%-10s %.2f  ||  ",studAr[x][y].getName(),studAr[x][y].getAverage());

                }
                else{
                    System.out.printf("%-10s %.2f",studAr[x][y].getName(),studAr[x][y].getAverage());

                }
            }
            System.out.println();
        }
    }


    // ------------------------------------------------------- Do Something -------------------------------------------------------

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
    static void arrangeByRow(Students[][] students, String[] sections ){
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
    static Students[] getAllTopStudents(Students[][] students, int noOfSections, int noOfStudents ){
        int totalNoOfStudents = noOfStudents * noOfSections;

        Students[] studList = new Students[totalNoOfStudents];

        int index = 0;
        for(int i = 0; i < students.length; i++){
            for(int j =0; j < students[i].length; j++){
                studList[index++] = students[i][j];
            }
        }

        // Ordering them from largest to smallest
        for(int i = 1; i < studList.length - 1; i++){
            for(int j = i + 1; j < studList.length; j++){
                if (studList[i].getAverage() < studList[j].getAverage())
                {
                    Students temp = studList[i];
                    studList[i] = studList[j];
                    studList[j] = temp;
                }
            }
        }

        return studList;

    }

}

class Students{
    private String studName, studSection;
    private int[] studGrades;
    private double studAverage;

    Students(String name, String section, int[] grades){
        this.setName(name);
        this.setSection(section);
        this.setGrade(grades);
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