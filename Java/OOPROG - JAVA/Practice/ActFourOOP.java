/*
    Name: Barral, Jacinth Cedric C.
    Date: September 18, 2024
    Description: Midterm - Lab.Act.#04 - Coding Practice with 
    Enhanced for Loops and 2 Dimensional Arrays in Java


*/

 // Accepts input between 70 - 100, if number is outside range, display err msg
 // Sort the students grades by ascending order (low - High)
 // Traverse the 2d array with ENHANCED FOR Loops
 // Calculate each students AVERAGE
 
 
 // Input Format 
 // Enter grades for Student 1 ( 70 - 100)
 // Student's grade 1: 89
 // Student's grade 2: 89
 // Student's grade 3: 89
 // Student's grade 4: 89
 
 // Display Format
 
 // Sorted grades for Student 100
 // 79 85 88 90 92
 // Average grade for Student 1: 86.80
 
 
import java.util.Random;
import java.util.Scanner;
class ActFourOOP{
    
    final static int minGrade = 70;
    final static int maxGrade = 100;
    static int numOfStud = 3, numOfGrd = 5;
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] debugData = new int[][] {
            {90, 79, 89, 73, 78, 84, 81},
            {81, 81, 91, 95, 80, 91, 78},
            {99, 96, 87, 90, 84, 70, 91},
        };
        String[][] studAtt = {
                {
                    "Juan", "Jose", "Maria", "Andres", "Ana",
                    "Luz", "Jinshi", "Aling Nena", "Rizal", "Changli",
                    "Diego", "Liza", "Lourdes", "Carlos", "Isabel",
                    "Raiden Mei", "Emilio", "Raiden Ei", "Fernando", "Bong",
                    "Pia", "Lito", "Tomas", "Mylene", "Vicente"
                },
                {
                    "BSIT", "BSCS", "BSECE", "BSME", "BSN",
                    "BSA", "BSEd", "BSBA", "BSHRM", "BSM",
                    "BSArch", "BSAcT", "BSMT", "BSCE", "BSTM"
                },
                {}
        };
        String[] menuOpt = {"Input Grades", "Debug Mode (Hard Coded Data)", "Exit Program"};
        StudentData studData = new StudentData();


        mainLoop(studData, studAtt, debugData, menuOpt, in);

        System.out.println("Thank you for using the program, see you again! :D");
//        debugMode(studData,studAtt,debugData,in);
        in.close();
    }









    // **************************************** Main Loop ****************************************
    public static void mainLoop(StudentData studData, String[][] studAtt, int[][] debugData,
                                String[] menuOpt, Scanner in){

        boolean exitLoop = false;
        int attempts =1;
        String frmt;
        do{
            frmt = attempts == 1 ? "First Attempt, " : "Attempts:";
            System.out.print("\n******************************************************\n");
            System.out.printf("\t\t\t   %s No. %d\n",frmt, attempts);
            System.out.println("******************************************************");

            System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (menuOpt.length -1));
            dispOpts(menuOpt, "Exit Program");


            System.out.print("\n-->: ");
            int choice = checkValidIn(in, "-->");
            if(!isInputvalid(in, menuOpt.length, choice)){
                continue;
            }



            studData = eventCont(studData, studAtt, debugData, choice,in);

            sortingAlgo(studData.getStudGrds());

            setStudAve(studData);

            System.out.print("******************************************************\n");
            dispArray(studData);
            System.out.print("******************************************************\n");


            System.out.println("\t\t\t  List Of Current Students");
            System.out.print("******************************************************\n\n");
            dispStudentInfo(studData);
            System.out.print("******************************************************\n");


            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );
            System.out.println();
            attempts++;

        }while(!exitLoop);

    }


    // **************************************** User Input ****************************************
    public static boolean askYesOrNo(Scanner in, String msg){
        boolean value;
        do{
            System.out.printf("%s.\n", msg);
            System.out.print("Your choice: ");
            char input = in.next().toUpperCase().charAt(0);

            if(input == 'Y' || input == 'N'){
                value = input == 'N';
                break;
            }
            else{
                System.out.println("\n-------------------------------------------------------");
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                System.out.println("-------------------------------------------------------");
            }


        }while(true);


        return value;

    }
    public static boolean isInputvalid(Scanner in, int menuSize, int choice){
        if( choice > menuSize || choice < 0){
            in.nextLine();
            System.out.println("Index number is not within the given options, try again!\n");
            System.out.print("Press ENTER key to continue...");
            in.nextLine();
            return false;
        }
        return true;
    }


    // **************************************** Output / Display ****************************************
    public static void displayHeader(){
        System.out.print("\n\t**********************************************************************************\n");
        System.out.printf("%-32s  %s\n", " ", "Working with 2D Arrays ");
        System.out.printf("%-31s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-35s  %s\n", " ", "Lab - Activity 3");
        System.out.print("\t**********************************************************************************\n");



    }

    public static void dispArray(StudentData studData){
        System.out.print("");
        // String dispFormat = "";
        int stud =0;
        for(int[] students : studData.getStudGrds() ){
            System.out.printf("Sorted Grades for %s, Student %d:\n",studData.getStudAttributes()[stud][0], stud+1);
            for(int studGrade : students){
                // j++;
                // String dispFormat = (j != numArr[j].length -1) ? ", " : " ";
                System.out.print(studGrade + " ");
            }

            System.out.printf("\nAverage grade for %s, Student %d: %.2f\n",studData.getStudAttributes()[stud][0], stud+1, studData.getStudAve(stud));
            System.out.println();
            stud++;
        }


    }

    public static void dispStudentInfo(StudentData studentData){
        String[][] studAtts = studentData.getStudAttributes();
        double[] studAve = studentData.getStudAve();

        int courseLen = getStrLen(studAtts[1]);
        int nameLen = getStrLen(studAtts[0]);
        int finalLen;

        for(int i =0; i < studAtts.length; i++){
            finalLen = nameLen > courseLen ? nameLen + 2 : courseLen + 2;
//            System.out.println(finalLen);
            System.out.printf("\t\tName: %-"+ (finalLen)+"s   Section: TBA\n", studAtts[i][0].trim());
            System.out.printf("\t\tCourse: %-"+(finalLen)+"s ID No. %s\n", studAtts[i][1].trim(), studAtts[i][2].trim());
            System.out.printf("\t\tAverage: %-"+(finalLen)+".2fRanking: TBA\n", studAve[i]);
            System.out.println();
        }
    }

    public static void dispOpts(String[] array, String exitKey){
        int arrayLength = array.length;
        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals(exitKey)){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s.\n", (arrayLength - i) - 1, array[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s.\n", (i+1), array[i]);
            }
        }
    }

    // **************************************** Event Switch & Algorithm ****************************************
    public static StudentData eventCont(StudentData studData, String[][] studAtt, int[][] debugData, int choice, Scanner in){
        switch(choice){
            case 1:
                studData = new StudentData(numOfStud, numOfGrd, studAtt);
                getStudentGrades(in, studData.getStudGrds(), studData.getStudAttributes());

                break;
            case 2:
                studData = new StudentData(numOfStud, numOfGrd, studAtt);
                studData.setStudGrds(debugData);
                break;

            case 0:
                System.out.println("\nThank you for using the program, come again :D!\n");
                System.exit(0);
                break;

        }
        return studData;
    }

    public static void sortingAlgo(int[][] studGrades){
        for(int k = 0; k < studGrades.length; k++ ){

            int minIndex;
            int[] tempAr = studGrades[k];
            int n = tempAr.length;

            for(int  i=0; i < n -1; i++){
                minIndex =i;
                for(int j = i +1; j < n; j++){
                    if(tempAr[j] < tempAr[minIndex]){
                        minIndex =j;
                    }
                }
                if(minIndex != i){
                    int temp = tempAr[minIndex];
                    tempAr[minIndex] = tempAr[i];
                    tempAr[i] = temp;
                }
            }
        }
    }

    // **************************************** Get and Set Data ****************************************
    public static int getStrLen(String[] orgStr){
        int len = 0;
        for(String str : orgStr){
            if(str.length() > len){
                len = str.length();
            }
        }

        return len;
    }
    public static double getAverage(int[] grades){
        int total =0;
        for(int grade : grades){
            total += grade;
        }

        return (double) total / grades.length;
    }

    public static void getStudentGrades(Scanner in, int[][] numArr, String[][] studAtts){

        for(int i = 0; i < numArr.length; i++){
            boolean isValid = false;
            int num =0;
            System.out.printf("Enter grades for %s, Student %d (%d - %d)\n\n",studAtts[i][0], (i+1), minGrade, maxGrade);
            for(int j = 0; j < numArr[i].length; j++){
                System.out.printf("Student's Grade %d: ", j+1);

                num = checkValidIn(in, "Student's Grade " +  (j+1));
                isValid = checkInputRange(num);

                if(!isValid){
                    j--;
                    System.out.printf("Invalid Grade! Please enter a grade between %d and %d:\n", minGrade, maxGrade );
                    continue;
                }
                else{
                    numArr[i][j] = num;
                }

            }
            System.out.println();
        }

//        return numArr;
    }

    public static void setStudAve(StudentData studData){
        int stud =0;

        for(int[] students : studData.getStudGrds()){
            studData.setStudAve(getAverage(students), stud);
            stud++;
        }


    }

    // **************************************** Other Logic ****************************************
    public static boolean checkInputRange(int num){

//        if(num >= minGrade && num <= maxGrade){
//            return true;
//        }
//        return false;

        return num >= minGrade && num <= maxGrade;

    }
    public static int checkValidIn(Scanner in, String alert){
        while(!in.hasNextInt()){
            System.out.println("Input only integers, try again!");
            System.out.print(alert + ": ");
            in.next();

        }
        return in.nextInt();


    }

    public static void debugMode(StudentData studData, String[][] studAtt, int[][] codedArr, Scanner in){

        boolean exitLoop = false;
        int attempts =1;
        String frmt;
        do{
            frmt = attempts == 1 ? "First Attempt, " : "Attempts:";
            System.out.print("\n******************************************************\n");
            System.out.printf("\t\t%s No. %d\n",frmt, attempts);
            System.out.print("******************************************************\n");

            studData = new StudentData(numOfStud, numOfGrd, studAtt);


//            getStudentGrades(in, studData.getStudGrds(), studData.getStudAttributes());

            studData.setStudGrds(codedArr);
            sortingAlgo(studData.getStudGrds());

            setStudAve(studData);
            System.out.print("******************************************************\n");
            dispArray(studData);
            System.out.print("******************************************************\n");


            System.out.println("\t\t\t  List Of Current Students");
            System.out.print("******************************************************\n\n");
            dispStudentInfo(studData);
            System.out.print("******************************************************\n");


            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );
            System.out.println();
            attempts++;
        }while(!exitLoop);


    }

}

class StudentData{
    private final int maxIdNum = 9;
    private Random rand;
    private int[][] studGrds;
    private String[][] studAttributes;
    private double[] studAve;

    public StudentData(int numOfStud, int numOfGrd, String[][] studAttributes){
        rand = new Random();
        studGrds = new int[numOfStud][numOfGrd];
//        studIdNum = new String[numOfStud];
//        studName = new String[numOfStud];
//        studCourse = new String[numOfStud];
        this.studAttributes = new String[numOfStud][3];
        studAve = new double[numOfStud];

        genStudAttrib(studAttributes);
    }

    public StudentData(){

    }
    public String genIdNum(){
        StringBuilder sb = new StringBuilder();


//        while(sb.length() < maxIdNum){
//            sb.append(rand.nextInt(9) +1);
//        }

        for(int i =0; i < maxIdNum; i++){

            sb.append(i == 0 ? rand.nextInt(2)+1 :
                    i == 1 ? rand.nextInt(9)+1 :
                    i ==2 ? "-"
                    : rand.nextInt(9)+1);
        }

        return sb.toString();
    }

    public void genStudAttrib(String[][] studAttributes){

        int numOfNames = studAttributes[0].length;
        int numOfCourses = studAttributes[1].length;

        for(int i =0; i< this.studAttributes.length; i++){
            this.studAttributes[i][0] = studAttributes[0][rand.nextInt(numOfNames)];
            this.studAttributes[i][1] = studAttributes[1][rand.nextInt(numOfCourses)];
            this.studAttributes[i][2] = genIdNum();
        }

    }



    public void setStudAve(double studAve, int index){
         this.studAve[index] = studAve;
    }

    public double getStudAve(int index){
        return studAve[index];
    }
    public double[] getStudAve(){
        return studAve;
    }


    public void setStudGrds(int[][] studGrds){
        this.studGrds = studGrds;
    }

    public int[][] getStudGrds(){
        return studGrds;
    }

    public String[][] getStudAttributes(){
        return  studAttributes;
    }

}
