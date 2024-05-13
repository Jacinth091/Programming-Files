import java.util.Scanner;
class SemiFinal1B
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[][] drinks = {
		    {"Pepsi","Mt. Dew", "Mirinda", "Lipton", "7-Up"},
		    {"Coke","Coke-Zero", "Coke-Diet", "Sprite", "Fanta"},
		    {"Black","Latte", "Cappuccino", "Frappuccino", "Affogato"},
		    {"Iced","Expresso", "Mocha", "Americano", "Flat-white"},

		};
		boolean ifFound = false;
		
		String toSearch;
		 int lrow =0, lcol=0;
		
		
		for(int i=0; i<drinks.length; i++){
		    for(int j =0; j < drinks[0].length; j++){
		        System.out.printf("%-15s", drinks[i][j]);
		    }
		    System.out.print("\n");
		}
		
		System.out.print("Enter the beverage to search: ");
		toSearch = in.nextLine();
		
		for(int i=0; i<drinks.length; i++){
		    for(int j =0; j < drinks[0].length; j++){
		        if(drinks[i][j].equalsIgnoreCase(toSearch)){
		            lrow = (i+1);
		            lcol = (j+1);
		            ifFound = true;
		        }
		    }
		}
		if(ifFound){
		    System.out.printf("%s is found at Row: %d, Col: %d\n", toSearch, lrow,lcol);
		}
		else{
		    System.out.printf("%s can not be found!\n", toSearch);
		}
		
		
		
		
	}
}
