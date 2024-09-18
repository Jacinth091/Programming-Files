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
 
 
import java.util.Scanner;
class ActFourOOP{
    
    final static int minGrade = 70;
    final static int maxGrade = 100;
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int[][] numArr = new int[3][3];
        
        int[][] arr= new int[][] {
            {90, 79, 89, 70, 78, 100, 81},
            {70, 81, 91, 85, 80, 91, 78},
            {78, 96, 87, 90, 84, 80, 91},
        };
        
        
        // getStudentGrades(in, numArr);
            
        dispArray(arr);
        
        
        for(int k = 0; k < arr.length; k++ ){
            // arr[i] = sortingAlgo(arr[i]);
                        
            int minIndex;
            int[] tempAr = arr[k];
            // int stud = studGrades.length, grades = studGrades[0].length;
            // int[] temp = new int[grades];
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
        System.out.println();
        
        dispArray(arr);
        
    }
    
    public static int[][] getStudentGrades(Scanner in, int[][] numArr){
        
        for(int i = 0; i < numArr.length; i++){
            boolean isValid = false;
            int num =0;
            System.out.println("Enter grades for Student 1 (70 - 100): ");
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
        }
        
        return numArr;
    }
    
    // public static int[] sortStudentGrades(int[] studGrades){
        
    //     int minIndex, n = studGrades.length;
    //     for(int i = 0; )
        
        
    //     return studGrades;
        
        
        
        
    // }
    
    public static int[] sortingAlgo(int[] studGrades){
   
        
        int minIndex;
        // int stud = studGrades.length, grades = studGrades[0].length;
        // int[] temp = new int[grades];
        int n = studGrades.length;
        
        for(int  i=0; i < n -1; i++){
            minIndex =i;
            for(int j = i +1; j < n; j++){
                if(studGrades[j] < studGrades[minIndex]){
                    minIndex =j;
                }

            }
            if(minIndex != i){
                int temp = studGrades[minIndex];
                studGrades[minIndex] = studGrades[i];
                studGrades[i] = temp;
            }



        }



        return studGrades;
    }

    
    public static boolean checkInputRange(int num){
        
        if(num >= minGrade && num <= maxGrade){
            return true;
        }
        return false;
        
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

        for(int[] students : numArr ){
        //  int j =0;
            for(int studGrade : students){
                // j++;
                // String dispFormat = (j != numArr[j].length -1) ? ", " : " ";
                System.out.print(studGrade + " ");
            }
            System.out.println();
        }
        
        
    }
    
}
