public class DecimailToBinary {

    public static void main(String[] args) {
        int DecNum = 17;
        int BinNum = 0;
        int pow = 0;
        while (DecNum > 0){
            int rem = DecNum % 2;
            BinNum = BinNum + (int)(rem*Math.pow(10,pow));
            DecNum = DecNum / 2;
            pow++;
        }
        System.out.println(BinNum);
    }
}
