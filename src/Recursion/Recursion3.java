package Recursion;

public class Recursion3 {


    // LINEAR RECURSION
    public static void main(String[] args) {
        int n = 10;

        System.out.println(Sum(n));

    }


    public static int Sum(int n){

        if(n==0){
            return 0;
        }

        return n + Sum(n-1);

    }
}
