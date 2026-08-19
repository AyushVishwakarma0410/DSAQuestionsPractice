package ArraysAplha;

public class TotalSubArrays {
    public static void main(String[] args) {

        int [] arr = {2,4,6,8,10};
        int totalSubArrays = 0;
        for( int i = 0 ; i < arr.length;i++){
            int start = i;
            for( int j = start; j < arr.length ; j++){
                int end= j;
                for( int k = start; k <=end;k++){
                    System.out.print(arr[k]+" ");
                }

                System.out.println();
                totalSubArrays++;
            }

            System.out.println();
        }

        System.out.println("TotalSubArrays :"+ totalSubArrays);
    }

}
