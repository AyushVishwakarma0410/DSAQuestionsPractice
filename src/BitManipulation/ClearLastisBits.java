package BitManipulation;

public class ClearLastisBits {
    public static void main(String[] args) {


        int i = 15;
        System.out.println(clearIBits(i,2));
    }

    // for this we are going to use -1, but how we get -1 ? we know 0, we know negation, ~0 means -1


    public static int clearIBits(int n, int i){
        int minus1 = ~0<<i;

        return n & minus1;
    }
}
