package DP.Memorization;

public class PalindromeCheckUsingDP {

    public static void main(String[] args) {
        String s = "abccba";

        System.out.println(isPal(s,0,s.length()-1,new Boolean[0][s.length()]));
    }

    public static boolean isPal(String s, int i, int j, Boolean[][] pal) {

        if (i >= j) {
            return true;
        }

        if (pal[i][j] != null) {
            return pal[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return pal[i][j] = false;
        }

        return pal[i][j] = isPal(s, i + 1, j - 1, pal);
    }
}
