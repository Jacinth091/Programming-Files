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
        int[][] arr= new int[][] {
            {90, 79, 89, 70, 78, 100, 81},
            {70, 81, 91, 85, 80, 91, 78},
            {99, 96, 87, 90, 84, 80, 91},
        };
        String[][] studAtt = {
                {
                    "Juan", "Jose", "Maria", "Andres", "Ana",
                    "Luz", "Pedro", "Aling Nena", "Rizal", "Karla",
                    "Diego", "Liza", "Lourdes", "Carlos", "Isabel",
                    "Ninoy", "Emilio", "Gloria", "Fernando", "Bong",
                    "Pia", "Lito", "Tomas", "Mylene", "Vicente"
                },
                {
                    "BSIT", "BSCS", "BSECE", "BSME", "BSN",
                    "BSA", "BSEd", "BSBA", "BSHRM", "BSM",
                    "BSArch", "BSAcT", "BSMT", "BSCE", "BSTM"
                }
        };
        StudentData studData = new StudentData(numOfStud, numOfGrd, studAtt);
//        studData.genStudAttrib();

//
//        System.out.println(studData.genIdNum());
//        System.out.println(studData.genIdNum());
//        System.out.println(studData.genIdNum());

        for(String[] student : studData.studAttributes){
            for(String studAtts : student){
                System.out.print(studAtts + " ");
            }
            System.out.println();
        }


//        dispArray(studData.studGrds);

//
//        getStudentGrades(in, numArr);
//        sortingAlgo(numArr);
//        System.out.println();
//        dispArray(numArr);
        
    }
    
    public static void getStudentGrades(Scanner in, int[][] numArr){
        
        for(int i = 0; i < numArr.length; i++){
            boolean isValid = false;
            int num =0;
            System.out.printf("Enter grades for Student %d (%d - %d)\n\n", (i+1), minGrade, maxGrade);
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

    public static double getAverage(int[] grades){
        int total =0;
        for(int grade : grades){
            total += grade;
        }

        return (double) total / grades.length;
    }
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
    
    public static void dispArray(int[][] numArr){
        System.out.print("");
        // String dispFormat = "";
        int stud =1;
        for(int[] students : numArr ){
            System.out.printf("Sorted Grades for Student %d:\n", stud);
            for(int studGrade : students){
                // j++;
                // String dispFormat = (j != numArr[j].length -1) ? ", " : " ";
                System.out.print(studGrade + " ");
            }
            System.out.printf("\nAverage grade for Student %d: %.2f\n", stud, getAverage(students));
            System.out.println();
            stud++;
        }
        
        
    }
    
}

class StudentData{
    private final int maxIdNum = 9;
    private Random rand;
    private int[][] studGrds;
     String[][] studAttributes;
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
            for(int j =0; j < this.studAttributes[i].length; j++){

                this.studAttributes[i][0] = studAttributes[0][rand.nextInt(numOfNames)];
                this.studAttributes[i][1] = studAttributes[1][rand.nextInt(numOfCourses)];
                this.studAttributes[i][2] = genIdNum();

            }
        }

    }

}
