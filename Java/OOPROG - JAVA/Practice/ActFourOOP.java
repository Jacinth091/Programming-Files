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
    static int numOfStud = 3, numOfGrd = 5, numOfAttrib =5;
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] debugData = new int[][] {
            {99, 96, 87, 90, 84, 70, 91},
            {89, 96, 73, 71, 80, 70, 91},
            {89, 96, 73, 71, 80, 70, 91},
            {79, 76, 93, 80, 80, 95, 83},
        };
        String[][] studAtt = {
                {
                    "Juan", "Jose", "Maria", "Andres", "Ana",
                    "Luz", "Jinshi", "Aling Nena", "Rizal", "Changli",
                    "Diego", "Jacinth", "Lourdes", "Carlos", "Kanding",
                    "Raiden Mei", "Emilio", "Raiden Ei", "Fernando", "Bong",
                    "Pia", "Lito", "Tomas", "Mylene", "Vicente"
                },
                {
                    "BSIT", "BSCS", "BSECE", "BSME", "BSN",
                    "BSA", "BSEd", "BSBA", "BSHRM", "BSM",
                    "BSArch", "BSAcT", "BSMT", "BSCE", "BSTM"
                },

        };
        String[] menuOpt = {"Input Grades", "Debug Mode (Hard Coded Data)", "Random Data","Exit Program"};
        StudentData studData = new StudentData();

        displayHeader();
        mainLoop(studData, studAtt, debugData, menuOpt, in);

        System.out.println("Thank you for using the program, see you again! :D");
        in.close();
    }

    // **************************************** Main Loop ****************************************
    public static void mainLoop(StudentData studData, String[][] studAtt, int[][] debugData,
                                String[] menuOpt, Scanner in){

        boolean exitLoop = false;
        int attempts =1;
        String frmt; // formatting
        do{
            frmt = attempts == 1 ? "First Attempt, " : "  Attempts:";
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

            // setting StudentData attirbutes, to what option is picked
            studData = eventCont(studData, studAtt, debugData, choice,in);

            // Start Using Sorting algo to sort the grades, Selection Sort
            sortingAlgo(studData.getStudGrds());

            // Getting the averages of each students and setting them in the StudentData, ave Array
            setStudAve(studData);
            // Determining Student Rank
            studData.determineStudRank(studData.getStudAve());
            // Setting rank titles to studAttribute Array in StudentData class
            studData.setTitlesToArray();



            System.out.println();
            // Displays the sorted, the grades, and the average
            System.out.print("******************************************************\n");
            dispArray(studData);
            System.out.print("******************************************************\n");

            // displays the list of students and their student info
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
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-23s  %s\n", " ", "Enhanced For Loop and 2D Arrays");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-30s  %s\n", " ", "Lab - Activity 4");
        System.out.print("**********************************************************************************\n");



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
            System.out.printf("\t\tName: %-"+ (finalLen)+"s   ID No. %s\n", studAtts[i][0].trim(), studAtts[i][3].trim());
            System.out.printf("\t\tCourse: %-"+(finalLen)+"s Section: %s\n", studAtts[i][1].trim(), studAtts[i][2].trim());
            System.out.printf("\t\tAverage: %-"+(finalLen)+".2fRanking: %s\n", studAve[i], studAtts[i][4].trim());
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
        studData = initStudData(numOfStud, numOfGrd, numOfAttrib,studAtt);


        switch(choice){
            case 1:
                getStudentGrades(in, studData.getStudGrds(), studData.getStudAttributes());

                break;
            case 2:
                studData = initStudData(debugData.length, debugData[0].length,numOfAttrib, studAtt);
                studData.setStudGrds(debugData);
                break;
            case 3:
                studData.setStudGrds(getRandomGrades());
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

    // ******************* HELPER METHOD
    public static StudentData initStudData(int numOfStud, int numOfGrd,int numOfAttrib, String[][] studAtt){
        return new StudentData(numOfStud, numOfGrd, numOfAttrib, studAtt);
    }

    public static int[][] getRandomGrades(){
        Random rand = new Random();
        int[][] studGrades = new int[numOfStud][numOfGrd];
        for(int i =0 ; i < numOfStud; i++){
            for(int j =0; j < numOfGrd; j++){
                studGrades[i][j] = rand.nextInt(31)+70;
            }
        }
        return studGrades;
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

}

class StudentData{
    private Random rand;
    private int[][] studGrds;
    private String[][] studAttributes;
    private double[] studAve;
    private int[] ranking;


    public StudentData(int numOfStud, int numOfGrd, int numOfAttrib, String[][] studAttributes){
        rand = new Random();
        studGrds = new int[numOfStud][numOfGrd];
//        studIdNum = new String[numOfStud];
//        studName = new String[numOfStud];
//        studCourse = new String[numOfStud];
        this.studAttributes = new String[numOfStud][numOfAttrib];
        studAve = new double[numOfStud];
        ranking = new int[numOfStud];

        genStudAttrib(studAttributes);
    }

    public StudentData(){

    }
    public String genIdNum(){
        StringBuilder sb = new StringBuilder();
        final int maxIdNum = 9;
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
            this.studAttributes[i][2] = genStudSection(this.studAttributes[i][1]);
            this.studAttributes[i][3] = genIdNum();
        }
    }
    public String genStudSection(String sectStr){
        StringBuilder sect = new StringBuilder();
        sect.append(sectStr + "-" + (rand.nextInt(4)+1));
//        System.out.println(sect.toString());
        return sect.toString();
    }

    public void determineStudRank(double[] studAveList){
        boolean[] flagged = new boolean[studAveList.length];
        int n = studAveList.length;
        int currRank =1;

        while(currRank <= n){
            int maxIndex = -1;
            for (int i = 0; i < n; i++) {
                if(!flagged[i] && (maxIndex == -1 || studAveList[i] > studAveList[maxIndex])){
                    maxIndex = i;
                }
            }
            for (int i = 0; i < n; i++) {
//                System.out.println(studAveList[i] == studAveList[maxIndex]);
                if(!flagged[i] && studAveList[i] == studAveList[maxIndex]){
                    ranking[i] = currRank;
                    flagged[i] = true;
                }
            }

            // Move to the next rank, accounting for the number of students tied
            int tiedStud = 0; // counter for students with the same average
            for (int i = 0; i < n; i++) {
                if (ranking[i] == currRank) {
                    tiedStud++;
                }
            }
            currRank += tiedStud; // Skip the ranks for tied students

        }

    }



    public String genRankTitle(int rank) {
        String[] sufx = {"th", "st", "nd", "rd"};
        int mod100 = rank % 100; // Getting the last two digit
        // FOr numbers that ends with 11, 12, 13, 14, etc
        if (mod100 >= 11 && mod100 <= 13) {
            return rank + sufx[0];
        }

        //if not, get the last digit for normal purposes, 21st, 22nd, etc
        int mod10 = rank % 10;
        switch (mod10) {
            case 1:
                return rank + sufx[1];
            case 2:
                return rank + sufx[2];
            case 3:
                return rank + sufx[3];
            default:
                return rank + sufx[0];
        }
    }

    public void setTitlesToArray(){
        for(int i =0; i< this.studAttributes.length; i++){

            this.studAttributes[i][4] = genRankTitle(ranking[i]);
        }
    }






    // **************************************** Setters And Getters ****************************************


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
