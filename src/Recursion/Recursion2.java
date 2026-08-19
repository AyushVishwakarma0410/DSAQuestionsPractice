package Recursion;


// LINEAR RECURSION

public class Recursion2 {
    // print numbers from n to 1

    public static void main(String[] args) {

        printNumbers(5);
        itrPrintNumbers(5);
        printNumbersInReverse(5);

    }



    public static void printNumbersInReverse(int n){
        if(n==0){
            System.out.println(0);
            return;
        }


        // order switched
        System.out.println(n);
        printNumbersInReverse(n-1);
    }


    public static void printNumbers(int n){
        if(n == 0){
            System.out.println(0);
            return;
        }


        printNumbers(n-1);
        System.out.println(n);

    }

    public static void itrPrintNumbers(int n ){


        for (int i = 0; i <=n ; i++) {
            System.out.println(i);
        }

    }


}
