public class WrapperClasses {
    public static void main(String[] args){
        // Wrapper Class = provides a way to use data types as reference data types
        //                 Reference data types contain useful methods
        //                 Can be used with collections (ex. Array Lists)


        // Primitives           //Wrapper
        //----------------------------------
        // boolean              // Boolean
        // char                 // Character
        // int                  // Integer
        // double               // Double

        // autoboxing = the automatic conversion that the Java compiler makes between
        //              the primitive types and their corresponding object wrapper class
        // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive types


        // Autoboxing

        Boolean a = true;
        Character b = '@';
        Integer c = 123;
        Double d = 3.14159;
        String e = "Jacinth";

        // Unboxing
        if(b == '@'){
            System.out.println("This is true");
        }

    }

}
