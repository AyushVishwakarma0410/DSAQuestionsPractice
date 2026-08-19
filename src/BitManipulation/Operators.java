package BitManipulation;

public class Operators {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int k = 3;

        // using AND
        System.out.println(1 & 2 );

        // using OR
        System.out.println(1 | 2 );

        // using XOR
        System.out.println((1 ^ 2)^3 );

        // using Negation
        System.out.println(~3); // -4
        System.out.println(~1); // -2

        // Binary Shift left

        System.out.println(i << 1); // will give 2 coz 01 -> 10

        // Binary Right shift

        System.out.println(j>> 1); // will give 1 coz 10 -> 01
    }
}
