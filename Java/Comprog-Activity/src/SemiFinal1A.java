/*
    Semifinal Exams Part 1 A
*/ 
class SemiFinal1A
{
	public static void main(String[] args) {
		String[] fruits = {"orange","apple","grapes","berry","banana" };
		
		String[] listOfFruits = {
            "orange","apple","banana","orange","grapes","berry","apple","orange","grapes","apple"
        };
        
        int[] noOfFruits = new int[fruits.length];
		
		
		for(int i = 0; i < fruits.length; i++){
		    for(int j = i+1; j < fruits.length; j++){
		        if (fruits[i].compareTo(fruits[j]) > 0){
		            String temp = fruits[i];
		            fruits[i] = fruits[j];
		            fruits[j] = temp;
		        }
		    }
		}
		
		
		for(int i = 0; i < fruits.length;i++){
		    int counter =0;
            for(int j =0; j < listOfFruits.length; j++){
    		  if(fruits[i].equals(listOfFruits[j])){
    		        counter++;
    		        noOfFruits[i] = counter;
		        }
            }
		}
		
		for(int i = 0; i < fruits.length;i++){
            System.out.printf("%s = %d\n", fruits[i], noOfFruits[i]);
		}
		
		
		
		
		
		
		
		
		
	}
}
