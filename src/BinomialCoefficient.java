public class BinomialCoefficient {

    public static void main(String[] args) {
        int n = 5;
        int r = 2;
        int a = factorial(n);
        int b = factorial(r);
        int c = factorial(n-r);
        System.out.println(a/(b*c));

    }

    static int factorial(int n){
        int f = 1;
        for( int i = 1 ; i <= n;i++){
            f = f *i;
        }

        return f;


    }
}

