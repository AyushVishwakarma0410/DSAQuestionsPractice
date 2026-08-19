package Recursion;

public class Recursion9 {


    // This is an optimized version of power of x in which we divide power(n) in equal halves
    public static void main(String[] args) {

        int x = 5;
        int n = 2;

        System.out.println(optPowerOfX(x,n));
    }
    public static int optPowerOfX(int x, int n){

        if(n==0){
            return 1;
        }


//        int half =  optPowerOfX(x,n/2) * optPowerOfX(x,n/2);
//            rewriting to optimize more

        int half =  optPowerOfX(x,n/2);

        half = half*half;

        // if n is odd. Why ?
        // because in division we lose a single occurrence.
        if(n%2!=0){
            half = x * half;
        }

        return half;
    }
}
