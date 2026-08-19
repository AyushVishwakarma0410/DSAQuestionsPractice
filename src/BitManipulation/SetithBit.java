package BitManipulation;




public class SetithBit {

    static int getithBit(int i, int pos){

        return  (i & (1<<pos))==0?0:1;

    }

static int setithBit(int i, int pos){

    return  (i | (1<<pos));
}

    public static void main(String[] args) {
        System.out.println(setithBit(1,2));
        System.out.println(getithBit(15,2));
    }
}
