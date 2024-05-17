/*
 Name: Barral, Jacinth Cedric C.
 Date: May 7, 2024
 Description: Creating a Student Class with Grades using 2d Arrays
 */
class Main2D{
    public static void main(String[] args){

        int noOfSections = 2, noOfStudents = 3;

        StudentsList[][] students  = new StudentsList[noOfSections][noOfStudents];
        StudentsList[] studentList = null;
        String[] section = {"BSIT - 1B", "BSIT - 1A"};
        String[] title = {"1st", "2nd", "3rd", "4th","5th","6th","7th","8th","9th","10th"};

        String[][] name = {
        {"John", "Mark", "Erick" }, 
        {"Sheena", "Diana", "Christina"}};

        int[][] gradeData = {
                {80,81,82},
                {93,89,84},
                {79,85,81},
                {92,85,88},
                {89,96,91},
                {82,89,85}
        };
        // Setting the HardCoded Data to the 2d Students Class Array
        initData(students, gradeData, name, section ,noOfSections, noOfStudents);
        
        // Computing and Setting Student's Average
        computeStudAve(students, noOfSections, noOfStudents);

//        students[0][0].studGrades = new int[]{80,81,82};
//        students[0][1].studGrades = new int[]{93,89,84};
//        students[0][2].studGrades = new int[]{79,85,81};
//
//        students[1][0].studGrades = new int[]{92,85,88};
//        students[1][1].studGrades = new int[]{89,96,91};
//        students[1][2].studGrades = new int[]{82,89,85};

        dispItemSection(students, studentList, section, title, noOfSections, noOfStudents);

    }
    
    // ------------------------------------------------------- INITIALIZE -------------------------------------------------------
        
    static void initData(StudentsList[][] students, int[][] gradeData, String[][] name, String[] section, int noOfSections, int noOfStudents){
        for (int i = 0; i < noOfSections; i++) {
            for (int j = 0; j < noOfStudents; j++) {
                // Getting grades data buffer
                int[] grades = new int[gradeData[i].length];

                for (int k = 0; k < gradeData[i].length; k++) {
                    // setting student's grade from 2d gradeData Array
                    grades[k] = gradeData[ i * noOfStudents + j][k];
                }
                // Passing and Setting the student's name, section and grade through the Students constructor
                students[i][j] = new StudentsList(name[i][j], section[i], grades);
            }
        }
        
        
    } 
    
    static void computeStudAve(StudentsList[][] students, int noOfSections, int noOfStudents){
        for(int i = 0; i< noOfSections; i++){
            for(int j = 0; j < noOfStudents; j++){
                // declaring and initializing and computing of average of students
                double studAve = students[i][j].computeAverage(students[i][j].getGrades());
                // Passing through the average data
                students[i][j].setAverage(studAve);
            }
        }
    }
        
    // ------------------------------------------------------- DISPLAY -------------------------------------------------------
    
    static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-25s  %s\n", " ", "Objects 2-Dimensional Arrays");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 11");
        System.out.print("**********************************************************************************\n");
    }

    static void dispStudents(StudentsList[] studList, String[] title, boolean isDeansList){
        System.out.println();
        System.out.print("************************************** BSIT **************************************\n");
        if(!isDeansList){
            System.out.printf("%-20s %-30s %-15s %-15s\n","No.","Name of Student","Average", "Section");
        }else{
            System.out.printf("%-20s %-30s %-15s %-15s\n","Rank","Name of Student","Average", "Section");
        }

        System.out.println("----------------------------------------------------------------------------------");
        
        for (int i=0; i<studList.length; i++)
        {
            if(!isDeansList){
                System.out.printf("%-20d %-30s %-15.2f %-15s\n",(i+1),studList[i].getName(),studList[i].getAverage(), studList[i].getSection());
            }
            else{
                if(studList[i].getAverage() > 85){
                    System.out.printf("%-20s %-30s %-15.2f %-15s\n",title[i],studList[i].getName(),studList[i].getAverage(), studList[i].getSection());
                }
            }


        }
        System.out.println("----------------------------------------------------------------------------------\n");

    }

    static void dispArrayItems(StudentsList[][] studAr, String[] sec) {
        System.out.println();
        System.out.printf("%-10s  || ", "Section");
        for(int j = 0; j < studAr[0].length; j++){
            if(j != studAr[0].length -1){
                System.out.printf("%-10s %-6s || ", "Name", "Average");
            }else{
                System.out.printf("%-10s %5s", "Name", "Average");
            }
            
        }
        System.out.println("\n----------------------------------------------------------------------------------");
        for (int x=0; x<studAr.length; x++)
        {   

            System.out.printf("%-11s || ",sec[x]);

            for(int y=0; y<studAr[0].length; y++)
            {
                if(y != studAr[0].length -1){
                    System.out.printf("%-10s %-7.2f || ",studAr[x][y].getName(),studAr[x][y].getAverage());

                }
                else{
                    System.out.printf("%-10s %-7.2f",studAr[x][y].getName(),studAr[x][y].getAverage());

                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    // ------------------------------------------------------- Arrange / Function todo something -------------------------------------------------------

    static void arrangeBySection(StudentsList[][] students, int noOfSections, int noOfStudents){
        for (int k=0; k<noOfSections; k++)
        {
            for (int i=0; i<noOfStudents-1; i++)
            {
                for (int j=i+1; j<noOfStudents; j++)
                {
                    if (students[k][i].getAverage() < students[k][j].getAverage())
                    {
                        StudentsList temp = students[k][i];
                        students[k][i] = students[k][j];
                        students[k][j] = temp;
                   }
                }
            }   
        }
    }
    
    static void arrangeByRow(StudentsList[][] students, String[] sections ){
        for(int i=0; i<students.length-1; i++)
         for (int j=i+1; j<students.length; j++)
            if (students[i][0].getAverage() < students[j][0].getAverage())
            {
                StudentsList[] temp = students[i];
               students[i] = students[j];
               students[j] = temp;
               
               String tmpSect = sections[i];
               sections[i] = sections[j];
               sections[j] = tmpSect;
            }
      
    }
    
    static StudentsList[] getStudents(StudentsList[][] students, int noOfSections, int noOfStudents ){
        int totalNoOfStudents = noOfStudents * noOfSections;

        StudentsList[] studList = new StudentsList[totalNoOfStudents];

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
                    StudentsList temp = studList[i];
                    studList[i] = studList[j];
                    studList[j] = temp;
                }
            }
        }

        return studList;

    }
    
    // ------------------------------------------------------- Code Body -------------------------------------------------------
    
    static void dispItemSection(StudentsList[][] students, StudentsList[] studentList, String[] section, String[] title, int noOfSections, int noOfStudents){
        
        displayHeader();

        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-13s  %s\n", " ", "Array contents before sorting students by section.");
        System.out.print("----------------------------------------------------------------------------------");
        dispArrayItems(students, section);
        System.out.println();

        arrangeBySection(students, noOfSections, noOfStudents);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-13s  %s\n", " ", "Array contents after sorting students by section.");
        System.out.print("----------------------------------------------------------------------------------");
        dispArrayItems(students, section);
        System.out.println();


        arrangeByRow(students, section);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-11s  %s\n", " ", "Array contents after sorting by rows on top per section.");
        System.out.print("----------------------------------------------------------------------------------");
        dispArrayItems(students, section);
        System.out.println("\n");


        studentList= getStudents(students, noOfSections, noOfStudents);
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-15s  %s\n", " ", "All Students from all Sections (by Average)");
        System.out.print("----------------------------------------------------------------------------------");
        dispStudents(studentList, title ,false);

        
        System.out.print("----------------------------------------------------------------------------------\n");
        System.out.printf("%-20s  %s\n", " ", "Dean's Listers from all Sections");
        System.out.print("----------------------------------------------------------------------------------");
        dispStudents(studentList, title ,true);
        
    }

}
class StudentsList{
    private String studName, studSection;
    private int[] studGrades;
    private double studAverage;


    StudentsList(String name, String section, int[] grades){
        this.setName(name);
        this.setSection(section);
        this.setGrade(grades);
    }

    // Setter and Getter for Name
    public void setName(String name){
        this.studName = name;
    }
    public String getName(){
        return this.studName;
    }

    // Setter and Getter for Section
    public void setSection(String section){
        this.studSection = section;
    }
    public String getSection(){
        return this.studSection;
    }

    // Setter and Getter for Average
    public void setAverage(double average){
        this.studAverage = average;
    }
    public double getAverage(){
        return this.studAverage;
    }
    
    // Setter and Getter for grades
    public void setGrade(int[] grades){
        this.studGrades = grades;
    }
    public int[] getGrades(){
        return this.studGrades;
    }
    
    // Computing the average of students
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
