package Recursion;

public class Recursion4 {

    // BINARY RECURSION - Two recursive calls

    public static void main(String[] args) {
        System.out.println(fibonacciSeries(6));
    }

    public static int fibonacciSeries(int target){

        if(target == 0){
            return 0;
        }
        if(target==1){
            return 1;
        }

        return fibonacciSeries(target-1) + fibonacciSeries(target-2);

    }
}


// In previous recursions, the input value 'n' is considered.
// Whether it is a sum or product, we need to use n
// But in fibonacci series, we do not consider the value on 'n',
// it is just used in order to get the value of the previous

// Doing stack trace of fibonacci provides you alot of answers