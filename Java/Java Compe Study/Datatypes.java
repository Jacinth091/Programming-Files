import java.io.*;
import java.util.*;

public class Datatypes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = 0;
        boolean byteFlag , shortFlag, intFlag, longFlag;
        testCases = in.nextInt();
        in.nextLine();
        String[] inputs = new String[testCases];
        
        for(int i=0; i < testCases; i++ ){
            inputs[i] = in.nextLine();
        }
        
        for(int i=0; i< inputs.length; i++){
            if(inputs[i] != null){
                try{
                    
                    long num = Long.parseLong(inputs[i]);
                    
                    byteFlag = (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE);
                    shortFlag  = num >= Short.MIN_VALUE && num <= Short.MAX_VALUE;
                    intFlag  = num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE;
                    longFlag  = num >= Long.MIN_VALUE && num <= Long.MAX_VALUE;
                    
                    
                    if(byteFlag && shortFlag && intFlag && longFlag){
                        System.out.println(num + " can be fitted in:");
                        System.out.println("* byte\n* short\n* int\n* long");
                        continue;
                    }
                    else if(shortFlag && intFlag && longFlag){
                        System.out.println(num + " can be fitted in:");
                        System.out.println("* short\n* int\n* long");
                        continue;
                    }
                    else if(intFlag && longFlag){
                        System.out.println(num + " can be fitted in:");
                        System.out.println("* int\n* long");
                        continue;
                    }
                    if(longFlag){
                        System.out.println(num + " can be fitted in:");
                        System.out.println("* long");
                        continue;
                    }

                        
                        
                    }catch(NumberFormatException e){
                        System.out.println(inputs[i] + " can't be fitted anywhere.");
                        continue;
                    }
                
                }

            
        }
        
        
        
    }
}