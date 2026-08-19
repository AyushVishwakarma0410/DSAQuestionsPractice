public class PrimeNumber {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(OptimizedCheckPrime(n));
        for( int i = 2; i <= n-1; i++){
            if(n==1) {
                System.out.println("n is not prime");

                return;
            }
            if(n==2) {
                System.out.println("n is prime");
                return;
            }
            if(n%i==0){
                System.out.println("n is not prime");
                return;
            }

        }
        System.out.println("n is prime");



    }


    static boolean OptimizedCheckPrime(int n){
        for( int i = 2; i <= Math.sqrt(n); i++){
            if(n==1) {
                System.out.println("n is not prime");

                return false;
            }
            if(n==2) {
                System.out.println("n is prime");
                return true;
            }
            if(n%i==0){
                System.out.println("n is not prime");
                return false;
            }

        }


        return true;
    }
}
