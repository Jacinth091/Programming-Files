public class ThreadingExample{

    public static void main(String[] args){
        int n = 5;

        Thread[] threads = new Thread[n];

        for(int i =0; i<n; i++){
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                for(int j =0; j < n; j++) {
                    System.out.println("Thread -> (" +
                            Thread.currentThread().getName() +
                            ") Thread Number: " + threadNum
                            + " Result: " + j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();

        }
    }
}


class Threading implements Runnable{

    private final int threadNum;

    public Threading(int threadNum){
        this.threadNum = threadNum;
    }


    @Override
    public void run(){
        for(int i =0; i < 5; i++){
            System.out.printf("%s: %d\n", Thread.currentThread().getName(), threadNum);

            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                e.printStackTrace();

            }
        }


    }




}