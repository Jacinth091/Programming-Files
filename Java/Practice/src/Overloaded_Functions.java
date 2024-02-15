public class Overloaded_Functions {
    public static void main(String[] args) {
        // Overloaded Functions = methods that share the same name but have different parameters
        //                        method name + parameters = method signature

        int x = addNum(1,2);
        double y = addNum(3.14,5.09);
        System.out.println("Int: " + x);
        System.out.println("Double: " + y);


    }
    static int addNum(int a, int b){
        System.out.println("OF Number 1");
        return a+b;
    }
    static int addNum(int a, int b, int c){
        System.out.println("OF Number 2");
        return a + b + c;
    }
    static int addNum(int a, int b, int c, int d){
        System.out.println("OF Number 3");
        return a + b + c + d;

    }
    static double addNum(double a, double b){
        System.out.println("DOUBLE: OF Number 1");
        return a+b;
    }
    static double addNum(double a, double b, double c){
        System.out.println("DOUBLE: OF Number 2");
        return a + b + c;
    }
    static double addNum(double a, double b, double c, double d){
        System.out.println("DOUBLE: OF Number 3");
        return a + b + c + d;

    }

}
