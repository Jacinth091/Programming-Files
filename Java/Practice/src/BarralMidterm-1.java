/*
    Name: Barral, Jacinth Cedric C.
    Date: March 21, 2024
    Description: Create a Java program for a college grading system GWA(General Weighted Average) that
      (1)accepts grades as input from 1.0-5.0 ONLY & 
      (2)accepts credit units. 
      (3)calculate the grade by the respective number of units of that subject (grade times unit), 
      (4)the sum of resulting numbers you obtained by grade(1) times units(2), 
      (5)the sum of credit units, and 
      (6)the GWA (sum of the resulting numbers(4) divides by sum of credit units(5) rounded to 2 decimal
*/
import java.util.Scanner;

class BarralMidterm{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfGrades = 0;
        int index = 0;
        float studentGrade, totalUnits = 0, totalGradePerUnit = 0, gradePerUnit = 0, GWA = 0, noOfUnits;
        
        boolean exitLoop;
        
    

        System.out.print("Enter the number of Grades to compute: ");
        noOfGrades = in.nextInt();
        

            
            
            do{
                noOfUnits =0;
                studentGrade = 0;
                System.out.printf("Enter grade #%d: ",(index+1));
                studentGrade = in.nextFloat();
                in.nextLine();
                
                if(studentGrade < 1.0 || studentGrade > 5.0 ){
                    System.out.println("Enter Grades between 1.0 and 5.0 only!");
                    continue;
                }
                
                System.out.print("Units: ");
                noOfUnits = in.nextInt();
                in.nextLine();
                
               gradePerUnit = studentGrade * noOfUnits;
               totalGradePerUnit += gradePerUnit;
               totalUnits += noOfUnits;
                
                index++;
                
            }while(index < noOfGrades);

       
       System.out.printf("GWA: %.2f\n", totalGradePerUnit/totalUnits);
        
        
        
        
        
        
        
        
        
        // for(int i = 0; i < noOfGrades; i++){
        //     System.out.printf("Enter grade #%d",(i+1));
        //     studentGrade = in.nextFloat();
        //     in.nextLine();
            
        //     if(studentGrade >= 1 && studentGrade <= 5 ){
        //         totalGradePerUnit += studentGrade;
        //     }
        //     else{
        //         cont
        //     }

            
            
        // }
        
        
        
        
        
        
        
        
        
        
    } 
    
}