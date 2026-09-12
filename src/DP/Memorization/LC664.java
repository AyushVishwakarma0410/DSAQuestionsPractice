package DP.Memorization;

public class LC664 {
    public static void main(String[] args) {

        String s = "abaca";

        System.out.println(solve(s,0,s.length()-1));
    }




    // mehhhhh ............
    public static int solve(String s,int start, int end) {


        if(start == end){
            return 1;
        }
        if(start > end){
            return 0;
        }

        int ans =Integer.MAX_VALUE; ;


        if(s.charAt(start) == s.charAt(end)){
            ans = solve(s,start,end-1);
        }
        else {
            for (int k = start; k < end; k++){
                ans = Math.min(ans,solve(s,start,k) + solve(s,k+1,end));
            }
        }






        return ans;



    }
}

/*
There are **three major flaws** in your code: two fundamental logic gaps in how you approach the DP transitions, and one runtime crash bug.

Here is a breakdown of why your approach fails, complete with the shortest possible failing test cases.

### 1. The Runtime Crash Bug

**Failing Test Case:** `"aa"` (Throws `StringIndexOutOfBoundsException`)

**Why it fails:**
Look at your skip logic:

```java
while (start < s.length() && start <= end && s.charAt(start)==s.charAt(start+1) )

```

If `s = "aa"`, you call `solve(0, 1)`. In the first iteration, `start` becomes `1`. The loop condition evaluates again: `start < 2` is true, `start <= 1` is true. Then it checks `s.charAt(1) == s.charAt(2)`. Index 2 does not exist, so your program immediately crashes. You need `start + 1 < s.length()` to prevent this.

---

### 2. Logic Flaw: Mishandling Matching Endpoints

**Failing Test Case:** `"abaca"`

* **Expected Output:** 3 (Print `aaaaa`, then `b`, then `c`)
* **Your Code's Output:** 4

**Why it fails:**
When `s[start] == s[end]`, your code does this:

```java
ans = solve(s, start+1, end-1);
return 1 + ans;

```

For `"abaca"`, `a == a`. Your code strips **both** ends, asks for the cost of `"bac"`, and adds 1. The cost of printing `"bac"` is 3. Adding 1 gives 4.

You incorrectly assume that printing the matching endpoints isolates the inner string. In reality, the optimal strategy for `"abaca"` is identical to printing `"abac"`. Because the first and last characters are the same, the last character can just "piggyback" on the base print of the first character without adding *any* extra turns. The correct transition when endpoints match is actually `solve(start, end - 1)`.

---

### 3. Logic Flaw: Missing the "Partition" Step

**Failing Test Case:** `"abacdcd"`

* **Expected Output:** 5 (Print `"aba"` in 2 turns + Print `"cdcd"` in 3 turns)
* **Your Code's Output:** 6

**Why it fails:**
When endpoints do **not** match, your code does this:

```java
ans = Math.min(solve(s,start+1,end), solve(s,start,end-1));
return 1 + ans;

```

Your code assumes that if the ends don't match, you *must* print either the leftmost or rightmost character entirely on its own (adding 1), and then solve the remainder.

This completely misses the possibility of **splitting the string into two independent chunks**. For `"abacdcd"`, peeling characters from the edges one by one forces the printer to be highly inefficient. The optimal move is to split the string at index 2 (`"aba"` and `"cdcd"`), solve them completely separately, and add their costs together.

### How to Fix It (The Standard DP Approach)

To solve this properly, you cannot just look at the edges. You must try splitting the string at *every possible middle index `k*` to see if combining two smaller subproblems yields a better score.

Here is the correct logic for the transitions:

1. **Base Case:** `start > end` returns 0, `start == end` returns 1.
2. **If ends match:** `dp(start, end) = dp(start, end - 1)`
3. **If ends don't match:** You loop a partition variable `k` from `start` to `end - 1`, and take the minimum of `dp(start, k) + dp(k + 1, end)`.
 */