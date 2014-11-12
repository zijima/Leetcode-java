/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x == Integer.MIN_VALUE){
            return false;
        }
        if(x < 0){
            return false;
        }
        
        if (x < 10){
            return true;
        }
        int reversed = 0;
        int saved = x;
        while (x != 0){
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return reversed == saved;
    }
}
