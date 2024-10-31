public class CalculateUsingThreads {

    public static void main(String[] args) {

        double[] arr = {23,123.351,12312.513,132.213,3124.213,513.34,51};


        Thread[] thds = new Thread[arr.length];


        for(int i =0; i < thds.length; i++){
            final int index =i;

            thds[i] = new Thread(() -> {

                System.out.printf("Thread Name: %s, Number: %.2f, Result: %.2f\n",
                        Thread.currentThread().getName(), arr[index], sqrt(arr[index]) );

            });
            try{
                thds[i].sleep(1000);
            }catch (InterruptedException e){

            }
            thds[i].start();

        }








    }



    public static void firstMethod(){
        int[] array = {20, 14, 56, 90, 21, 14, 13};

        Thread[] calcThread = new Thread[2];

        for(int i =0; i < array.length; i++){

            final int numToCalc = array[i];
            if(i % 2 == 0){
//                System.out.println("              Even: "+numToCalc);
                calcThread[0] = new Thread(()->{
                    System.out.println(numToCalc +" EVEN -> Sqrt: " + sqrt(numToCalc) );


                });

                calcThread[0].start();

            }
            else{
//                System.out.println("Odd: " + numToCalc);
                calcThread[1] = new Thread(()->{
                    System.out.println(numToCalc +" ODD -> Sqrt: " + sqrt(numToCalc) );
                });
                calcThread[1].start();

            }

        }

    }


    public static int sqrt(int num){
        return num * num;
    }

    public static double sqrt(double num){
        return num * num;
    }

}
