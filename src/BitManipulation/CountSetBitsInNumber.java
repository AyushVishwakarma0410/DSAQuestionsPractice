package BitManipulation;

public class CountSetBitsInNumber {
    public static void main(String[] args) {
        int n = 15;

        int i = 1;
        int count =0;
        while (n > 0){
            if((n & 1)!=0 ){ // check least significant bit
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }
}
