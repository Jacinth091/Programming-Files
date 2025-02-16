import java.io.*;
import java.util.*;
import java.util.regex.*;

public class RegularExpression {

    public static void main(String[] args) {
        MyRegex myRegex = new MyRegex();
        
        Scanner in = new Scanner(System.in);
        String input;
        
        boolean[] validIp = new boolean[6];
        
        for(int i = 0; i < validIp.length; i++){
            myRegex = new MyRegex(in.nextLine());
            validIp[i] = myRegex.validateIPAddress();
        }
        
        for(int i = 0; i < validIp.length; i++){
            System.out.println(validIp[i]);
        }
        
        
        
        
        
        
        
        
    }
}

class MyRegex {
    
    String pattern;
    String regEx = "^((0|00|000|1?\\d{1,3}|2[0-4]\\d|25[0-5])\\.){3}(0|00|000|1?\\d{1,3}|2[0-4]\\d|25[0-5])$";



    
    Pattern strPat;
    
    public MyRegex(){}
    public MyRegex(String pattern){
        this.pattern = pattern;
        this.strPat = Pattern.compile(regEx);
    }
    
    public boolean validateIPAddress(){
        Matcher matcher = strPat.matcher(pattern);
        return matcher.matches();
    }
    
}