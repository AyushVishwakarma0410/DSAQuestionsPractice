package BitManipulation;

public class clearRangeOfBits {
    public static void main(String[] args) {


        System.out.println(clearRangeOfBits(2,4,10));
    }

    public static int clearRangeOfBits(int i, int j, int n){

        // for b
        // 01 = 2^1-1
        // 011 = 2^2-1
        // 0111 = 2^3-1

        // here a = (~0)<<(j+1)
        // here b = (1<<i)-1

        int a = (~0)<<(j+1);
        int b = (1<<i)-1;

        int bitmask = a | b;


        return n & bitmask;




    }
}
