package TCS;

import java.util.Arrays;

public class TCSNQTQUESTIONASKED {

    // Question 1 : Greedy Algorithm Question, less hour after setting it in ascending order.
    // Question 2 : MST


    public static void main(String[] args) {

        int [][] arr = new int[3][2];

        arr[0][0] = 1;
        arr[0][1] = 3;

        arr[1][0] = 2;
        arr[1][1] = 2;

        arr[2][0] = 3;
        arr[2][1] = 1;
//        arr[1][2] = 3;


        // value swapping

        int [][] arr2 = new int[3][2];


        


     printArray(arr);

        System.out.println("AFTER SORTING");



        for (int i = 0; i < arr.length; i++) {
            // first element loop
            for (int j = 0; j < arr.length-1;j++){

                if(arr[j][1] > arr[j+1][1]) {
                    int temp0 = arr[j][0];
                    int temp1 = arr[j][1];

                    arr[j][0] = arr[j+1][0];
                    arr[j][1] = arr[j+1][1];

                    arr[j+1][0] = temp0;
                    arr[j+1][1] = temp1;
                }
            }
        }


//
//
//
//
      printArray(arr);


        for (int i = 0; i < arr.length; i++) {
            // first element loop
            for (int j = 0; j < arr.length-1;j++){

                if(arr[j][0] > arr[j+1][0]) {
                    int temp0 = arr[j][0];
                    int temp1 = arr[j][1];

                    arr[j][0] = arr[j+1][0];
                    arr[j][1] = arr[j+1][1];

                    arr[j+1][0] = temp0;
                    arr[j+1][1] = temp1;
                }
            }
        }

        System.out.println("AFTER SORTING AGAIN BY 1st COLUMN");
    printArray(arr);
    }



    public static void printArray(int [][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" i :"+ i + " j :"+ j + " = " + arr[i][j] + " ");
            }
            System.out.println();
        }



    }


}
