/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
/*public class Main
{
	public static void main(String[] args) {
		int number = 10;
		
        System.out.printf("Factorial of %d is: %d", number, factorial(number));
	}
	
	static int factorial(int n){
	    
	    if(n == 0){
	        return 1;
	    }
	    
	    return n * factorial(n-1);
	    
	}
}*/

/*public class Main{
    
    public static void main (String[] args) {
        int number = 7;
        System.out.printf("Total sum from 1 to %d: %d", number , sumOfNum(number));
        
    }
    
    static int sumOfNum(int n){
        
        if(n <= 0){
            return 0;
        }
        
        return n + sumOfNum(n-1);
    }
}*/

public class Recursions{
    public static void main (String[] args) {
        
        
       /* int seed = 1;
        int start =1;
        int res =0;
        int dupe;
        int n = 9;
        
        for(byte i = 0; i < (n); i++){


            if(!(i < (n))){
                break;
            }
            else{
                res = seed + start;
                seed = start;
                start = res;
            }
            System.out.printf("i : %d \n", i);
            System.out.printf("seed: %d \n", seed);
            
            

            
            
        }
        System.out.printf("Result: %d", seed);*/
        int number =3;
        System.out.printf("number at position %d is: %d", number, calcFiboSeq(number));
    }
    
    
    static int calcFiboSeq(int n){
        
        if(n == 0){
            return 0;
        }
        else if( n== 1){
            return 1;
        }
        
        
        return calcFiboSeq(n-1) + calcFiboSeq(n-2);
        
        
    }
}





























