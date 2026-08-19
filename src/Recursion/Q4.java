package Recursion;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Q4 {
    public static void main(String[] args) {
        String s = "abcab";
//        subStrings(s,0,0);
        System.out.println(subString1(s,0,0));


        // Aaam zindagi ( n^2 time )

//        for (int i = 0; i < s.length(); i++) {
//
//
//            for (int j = i; j < s.length(); j++) {
//
//                if(s.charAt(i)==s.charAt(j))
//                    System.out.println(s.substring(i,j+1));
//
//            }
//
//        }

    }
    public static void subStrings(String s, int a,int b){

        if(a==s.length()){
            return;
        }

        if(b==s.length()){

           subStrings(s,a+1,a+1);

            return;

            // remember this return
        }


        b = b + 1;
        if(s.charAt(a)==s.charAt(b-1)) {
            System.out.println(s.substring(a, b));
        }
        subStrings(s,a,b);

    }

    public static List<String> subString1(String s, int a, int b) {
        // Base Case 1: Start pointer reached the end
        if (a == s.length()) {
            return new ArrayList<>();
        }

        // Base Case 2: End pointer reached the end, move 'a' forward
        if (b == s.length()) {
            return subString1(s, a + 1, a + 1);
        }

        // 1. Get the current substring
        // ->  2. adding condition as per the question
        String current = "";
        if(s.charAt(a)==s.charAt(b)){
            current = s.substring(a, b + 1);

        }

        // 2. Get the list from all FUTURE recursive calls
        List<String> list = subString1(s, a, b + 1);

        // 3. Add current substring to the START of that list
        if(!current.isEmpty()){
            list.add(0, current);
        }

        // 4. Return the combined list to the previous caller
        return list;
    }
}


// advance mentos zindagi

/*
public static List<String> getSubstrings(String s) {
    List<String> result = new ArrayList<>();
    generate(s, 0, 0, result);
    return result;
}

private static void generate(String s, int a, int b, List<String> result) {
    if (a == s.length()) return;

    if (b == s.length()) {
        generate(s, a + 1, a + 1, result);
        return;
    }

    // Your logic: Only add if first and last chars match
    if (s.charAt(a) == s.charAt(b)) {
        result.add(s.substring(a, b + 1));
    }

    generate(s, a, b + 1, result);
}

*/