package INFOSYSAUG_2026;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;





// go to gemini for most basic solution
public class Q2AlternatingVowelsPath {

    static HashMap<Character,List<Character>> rules = new HashMap<>();
    static long MOD = 1000000007;
    static {
        rules.put('a', List.of('e'));
        rules.put('e', List.of('a', 'i'));
        rules.put('i', List.of('a', 'e', 'o', 'u'));
        rules.put('o', List.of('i', 'u'));
        rules.put('u', List.of('a'));
    }

    public static int getDirection(Character prevChar, Character currentChar){
        if(prevChar > currentChar) {
            return -1;
        }
        else if(prevChar < currentChar){
            return 1;
        }
        return 0;
    }

    public static long countPaths(char curr, int prevDirection, int len, int n){

        if(len==n){
            return 1;
        }

        long paths = 0;

        for(char next : rules.get(curr)){
            int currDir = getDirection(curr,next);


            // if same direction, skip as same direction movement is not allowed
            if(prevDirection!=0 && prevDirection==currDir){
                continue;
            }

            paths = (paths + countPaths(next,currDir,len+1,n)) % MOD;
        }


        return paths;
    }



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            sc.close();

            if (n == 1) {
                System.out.println(5);
                return;
            }

            // dp[direction][vowel] -> Row 0: DOWN, Row 1: UP, Row 2: START
            long[][] dp = new long[3][5];
            for (int i = 0; i < 5; i++) {
                dp[2][i] = 1;
            }

            for (int step = 2; step <= n; step++) {
                long[][] nextDp = new long[3][5];

                // 'a' -> 'e' (UP)
                nextDp[1][1] = (nextDp[1][1] + dp[0][0] + dp[2][0]) % MOD;

                // 'e' -> 'a' (DOWN), 'e' -> 'i' (UP)
                nextDp[0][0] = (nextDp[0][0] + dp[1][1] + dp[2][1]) % MOD;
                nextDp[1][2] = (nextDp[1][2] + dp[0][1] + dp[2][1]) % MOD;

                // 'i' -> 'a' (DOWN), 'e' (DOWN), 'o' (UP), 'u' (UP)
                nextDp[0][0] = (nextDp[0][0] + dp[1][2] + dp[2][2]) % MOD;
                nextDp[0][1] = (nextDp[0][1] + dp[1][2] + dp[2][2]) % MOD;
                nextDp[1][3] = (nextDp[1][3] + dp[0][2] + dp[2][2]) % MOD;
                nextDp[1][4] = (nextDp[1][4] + dp[0][2] + dp[2][2]) % MOD;

                // 'o' -> 'i' (DOWN), 'u' (UP)
                nextDp[0][2] = (nextDp[0][2] + dp[1][3] + dp[2][3]) % MOD;
                nextDp[1][4] = (nextDp[1][4] + dp[0][3] + dp[2][3]) % MOD;

                // 'u' -> 'a' (DOWN)
                nextDp[0][0] = (nextDp[0][0] + dp[1][4] + dp[2][4]) % MOD;

                dp = nextDp;
            }

            long ans = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    ans = (ans + dp[i][j]) % MOD;
                }
            }

            System.out.println(ans);
        }
    }



