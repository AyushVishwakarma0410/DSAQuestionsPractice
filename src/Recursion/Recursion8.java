package Recursion;

public class Recursion8 {
    public static void main(String[] args) {


        int x = 5;
        int n = 2;
        System.out.println(powerOfx(x,n));
    }
    public static int powerOfx(int x, int n){

        if(n==1){
            return x;
        }
        return x * powerOfx(x,n-1);
    }
}


// I hope you came here from the fibonacci series
// Here you can see, the value of 'n' is actually being used
// Unlike fib series in which we build up the base answers 0 and 1 by continuously adding them
// Here we multiply the previous answer with the current one.
// You can take it as, multiplying with the previous self


