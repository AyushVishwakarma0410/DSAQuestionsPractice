package Recursion;





// LINEAR RECURSION
public class Recursion1 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial(5));
        System.out.println(itrFacto(5));
    }



    // Bottom up

    public static int itrFacto(int n ){

        int ans = 1;
        for (int i = 1; i <= n; i++) {

            ans *=i;

        }

        return ans;


    }


    // Top down

    public static int factorial(int n){

        if(n==0){
            return 1;
        }

        return n * factorial(n-1);
    }

}
