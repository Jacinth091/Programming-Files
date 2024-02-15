class Printf_In_Java{
    public static void main(String[]args){
        
        // printf() = an optimal method to control, format and display text to the console window
        //            two arguments = format string + (object/variable/value)
        //            % [flags] [precision] [width] [cobversion-character]
        
        

        boolean isStudent = true;
        int myInt = 2304;
        double pie = 3.14159;
        String name = "Jacinth";
        char symbol = '@';

        // [conversion-character]
        System.out.printf("%b\n", isStudent);
        System.out.printf("%d\n", myInt);
        System.out.printf("%.2f\n", pie);
        System.out.printf("%s\n", name);
        System.out.printf("%c\n", symbol);
        System.out.println();

        // [Width]
        // Minimum number of characters to be written as output
        System.out.printf("Hello %-10s\n", name);

        // [precision]
        //sets number of digits when outputting floating-point numbers
        System.out.printf("The value of pie: %.2f\n",pie);

        // [flags]
        // adds an effect to output based on the flag added to format specifier
        // - : left-justify
        // + : output a plus (+) or minus (-) sign for a numeric value
        // @ : numeric values are zero-padded
        // , : comma grouping seperator if numbers > 1000

        
    }
}