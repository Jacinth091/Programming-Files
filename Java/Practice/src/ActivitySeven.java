/*
    Name: Barral, Jacinth Cedric C.
    Date: March 5, 2024
    Description: Activity 7 - Ternary Operator for Grade Rating
*/

import java.util.Scanner;

class ActivitySeven{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int grade;

        System.out.print("Enter Grade: ");
        grade = in.nextInt();

        System.out.println();

        System.out.printf("The grade %d %s! \n", grade,
                (grade>=95 && grade <=100)? "is Excellent":
                (grade>=90 && grade <=94) ? "is Very Good":
                (grade>=85 && grade <=89) ? "is Good":
                (grade>=80 && grade <=84) ? "is Satisfactory":
                (grade>=75 && grade <=79) ? "Needs Improvement":
                (grade>=70 && grade <=74) ? "is Poor": "is Invalid");
        if(grade<70 || grade > 100) {
            System.out.println("Enter grade only between 70-100, try again!");
        }

    }

}