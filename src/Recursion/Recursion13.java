package Recursion;

public class Recursion13 {
    public static void main(String[] args) {
            int n = 3 ;
            printBinaryStrings(n,0, "");
    }

    public static void printBinaryStrings(int n,int lastPlace, String s){

            if(n==0){
                System.out.println(s);
                return;
            }

            if(lastPlace==0){
                printBinaryStrings(n-1,0,s+"0");
                printBinaryStrings(n-1,1,s+"1");
            }
            else {
                printBinaryStrings(n-1,0,s+"0");
            }


    }
}

