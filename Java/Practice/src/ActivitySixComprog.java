import java.util.Scanner;
public class ActivitySixComprog
{
	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int grade;
        char choice;
        boolean isValid = false;
        
        do{
            grade = 0;
            choice ='0';
            System.out.print("\nEnter Grade: ");
            grade = in.nextInt();
            in.nextLine();
            
            if(grade > 100 || grade < 70){
                System.out.printf("Out of Range! \n");
            }
            else{
                String rating = "";
                switch(grade/5){
                    case 20:
                    case 19:
                        rating = "is Excellent!";
                    break;
                    case 18:
                        rating = "is Very Good!";
                    break;
                    case 17:
                        rating = "is Good!";
                    break;
                    case 16:
                        rating = "is Satisfactory!";
                    break;
                    case 15:
                        rating = "Needs Improvement!";
                    break;
                    case 14:
                        rating = "is Poor!";
                    break;
                    default:
                        System.out.printf("Out of Range!\n");
                        rating = "Invalid!!";
                    break;
            
                }
                System.out.println();
                System.out.printf("The grade %d %s\n",grade ,rating);
            
            }
            // Checking for Right character input
            do{
                System.out.print("Try Again (Y/N)?: ");
                choice = in.next().charAt(0);
                choice = Character.toUpperCase(choice);
                in.nextLine();
                
                
                if(choice != 'Y' && choice == 'N'){
                    System.out.println("\nExiting...");
                    isValid = true;
                    break;
                }
                else if(choice == 'Y'){
                    break;
                }
                else {
                    System.out.println("Invalid Input, Try again!");
                }
            }while(!isValid);
            
            if(choice == 'N'){
                break;
            }
            
        }while(true);
	}
}
