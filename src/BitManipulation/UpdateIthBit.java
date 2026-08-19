package BitManipulation;

public class UpdateIthBit {
    static int ClearithBit(int i, int pos) {
        int j = ~(1 << pos);
        return i & j;
    }
    static int setithBit(int i, int pos){

        return  (i | (1<<pos));
    }


    static int updateBit(int n, int i, int newBit){

//        if(newBit==0){
//            return ClearithBit(n,i);
//        }
//        else {
//         return setithBit(n,i);
//        }

        n = ClearithBit(n,i);

        return n | newBit<<i;  
    }


    public static void main(String[] args) {

    }
}
