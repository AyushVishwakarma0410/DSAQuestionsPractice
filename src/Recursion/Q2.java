package Recursion;

public class Q2 {
    public static void main(String[] args) {

        int num = 2019;
        StringBuilder sb = new StringBuilder();
        System.out.println(conversion(num));
    }

    public static String conversion(int num){

        if(num == 0){
            return "";
        }


        // digit -> String
        int rem = num%10;
        String ans = get(rem);

        return conversion(num/10)+ ans + " ";


    }
    public static String get(int num ){

//        switch (num){
//            case 1 :
//                return "one";
//            case 2 :
//                return "two";
//            case 3 :
//                return "three";
//            case 4 :
//                return "four";
//            case 5 :
//                return "five";
//            case 6 :
//                return "six";
//            case 7 :
//                return "seven";
//            case 8 :
//                return "eight";
//            case 9 :
//                return "nine";
//            default:
//                return "zero";
//        }


        String [] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            if(num>=0 && num <=9){
                return arr[num];
            }
        return "";
    }
}
