package BitManipulation;

public class clearithBit {


    static int getithBit(int i, int pos){

        return  (i & (1<<pos))==0?0:1;

    }

    static int setithBit(int i, int pos){

        return  (i | (1<<pos));
    }

    // make bit 0 at given pos
    static int ClearithBit(int i, int pos) {
        int j = ~(1 << pos);
        return i & j;
    }

    public static void main(String[] args) {
        int i = 15;
        System.out.println(ClearithBit(i,2));
    }
}
