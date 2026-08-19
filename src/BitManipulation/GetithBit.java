package BitManipulation;

public class GetithBit {
    public static void main(String[] args) {
        int i = 15;
        int pos = 2;

        if((i &(i<<pos))==0) {
            System.out.println("has zero");
        }
        else {
            System.out.println("has 1");
        }

    }
}
