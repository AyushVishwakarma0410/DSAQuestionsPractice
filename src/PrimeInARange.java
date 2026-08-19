public class PrimeInARange {
    public static void main(String[] args) {
        int n = 10;

        for( int i = 2; i <= n;i++){

            if(OptimizedCheckPrime(i)){
                System.out.println(i);
            }


        }
    }
    static boolean OptimizedCheckPrime(int n){
        for( int i = 2; i <= Math.sqrt(n); i++){
            if(n==1) {
//                System.out.println("n is not prime");

                return false;
            }
            if(n==2) {
//                System.out.println("n is prime");
                return true;
            }
            if(n%i==0){
//                System.out.println("n is not prime");
                return false;
            }

        }


        return true;
    }
}
