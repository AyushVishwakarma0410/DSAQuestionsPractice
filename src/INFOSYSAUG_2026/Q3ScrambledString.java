package INFOSYSAUG_2026;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3ScrambledString {
        static Map<String, Integer> memo = new HashMap<>();

        public static void main(String[] args) {


            String s = "gr";

            System.out.println(s.substring(s.length()-1));
            Scanner sc = new Scanner(System.in);
            if (!sc.hasNext()) return;
            String s1 = sc.next();
            if (!sc.hasNext()) return;
            String s2 = sc.next();

            int ans = getMinSwaps(s1, s2);
            if (ans >= 999999) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
            sc.close();




        }

        static int getMinSwaps(String s1, String s2) {
            if (s1.equals(s2)) {
                return 0;
            }
            if (s1.length() != s2.length()) {
                return 999999;
            }

            String key = s1 + "#" + s2;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int n = s1.length();
            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    memo.put(key, 999999);
                    return 999999;
                }
            }

            int minSwaps = 999999;
            for (int i = 1; i < n; i++) {

                System.out.println("Call :"+ i);
                int cost1 = getMinSwaps(s1.substring(0, i), s2.substring(0, i))
                        + getMinSwaps(s1.substring(i), s2.substring(i));

                System.out.println("Cost 1 :"+cost1);
                minSwaps = Math.min(minSwaps, cost1);

                int cost2 = 1 + getMinSwaps(s1.substring(0, i), s2.substring(n - i))
                        + getMinSwaps(s1.substring(i), s2.substring(0, n - i));
                minSwaps = Math.min(minSwaps, cost2);
                System.out.println("Cost 2 :"+cost2);

            }

            memo.put(key, minSwaps);
            return minSwaps;
        }

}
