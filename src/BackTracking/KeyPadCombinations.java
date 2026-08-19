package BackTracking;

public class KeyPadCombinations {
    public static void main(String[] args) {

    }
    static char [][] characters = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'}
            ,{'p','q','r','s'},{'t','u','v'}, {'w','x','y','z'}};




    public static void keyPad(String digits){



        int length = digits.length();

         sol(digits, 0, new StringBuilder());
    }

    public static void sol (String digits, int curr, StringBuilder sb){

        if (curr == digits.length()){
            System.out.println(sb.toString());
        }
        else {

            char[] letters = characters[Character.getNumericValue(digits.charAt(curr))];
            for (int i = 0; i < letters.length; i++) {
                sol(digits, curr + 1, new StringBuilder(sb).append(letters[i]));

            }

        }
    }
}
