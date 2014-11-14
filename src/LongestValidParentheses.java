/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4
 * 
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0 || n == 1){
            return 0;
        }
        int result = 0;
        char[] c = s.toCharArray();
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            if(c[i] == '('){
                int j = i + dp[i + 1] + 1;
                if(j < n && c[j] == ')'){
                    dp[i] = dp[i + 1] + 2;
                    if(j + 1 < n){
                        dp[i] += dp[j + 1];
                    }
                }
            }
            result = (result > dp[i]) ? result : dp[i];
        }
        return result;
    }
}
