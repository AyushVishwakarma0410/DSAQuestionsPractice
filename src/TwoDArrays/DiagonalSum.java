package TwoDArrays;

public class DiagonalSum {

    static int diagonalSum(int [][] matrix){

        int sum =0;
        for( int i=0; i <matrix.length;i++){
            // primary diagonal
            sum+=matrix[i][i];
            // secondary diagonal  j = n-1-i because i + j = n-1;
            if(i!=matrix.length-1-i){
                sum+= matrix[i][matrix.length-1-i];
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        int sum =0;

        // brute force
        for( int i = 0; i < arr.length;i++){
            for( int j=0; j < arr.length;j++){

                if(i==j){
                    sum += arr[i][j];
                }
                else if(i+j == arr.length-1){
                    sum+=arr[i][j];
                }

            }

        }
        System.out.println(sum);

    }
}
