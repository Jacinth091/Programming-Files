/*
    Name: Barral, Jacinth Cedric C.
    Date: March 5, 2024
    Description: Activity 6 - Switch Case for Grade Rating
*/

import java.util.Scanner;

class ActivitySix{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int grade;
        System.out.print("Enter Grade: ");
        grade = in.nextInt();

        System.out.println();
        if(grade > 100 || grade < 70){
            System.out.printf("The grade %d is Invalid!\n", grade);
            System.out.println("Enter grade only between 70-100, try again!");
        }
        else{
            switch(((grade / 5) *5)){
                case 95:
                case 100:
                    System.out.printf("The grade %d is Excellent!", grade);
                    break;
                case 90:
                case 94:
                    System.out.printf("The grade %d is Very Good!", grade);
                    break;
                case 85:
                case 89:
                    System.out.printf("The grade %d is Good!", grade);
                    break;
                case 80:
                case 84:
                    System.out.printf("The grade %d is Satisfactory!", grade);
                    break;
                case 75:
                case 79:
                    System.out.printf("The grade %d Needs Improvement!", grade);
                    break;
                case 74:
                case 70:
                    System.out.printf("The grade %d is Poor!", grade);
                    break;
                default:
                    System.out.printf("The grade %d is Invalid!\n", grade);
                    System.out.println("Enter grade only between 70-100, try again!");
                    break;


            }
        }




    }

}