/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /*
         * for each char, 
         * if current char != left, and not equal to right, then see if left side and right ride is palindrome
         * if c = left, try a[0-left-1] and a[right, end]
         *  n^2
        */
        if (s == null){
            return null;
        }
        int l = s.length();
        char[] a = s.toCharArray();
        if (l == 0 || l == 1){
            return s;
        }
        if (l == 2 && a[0] == a[1]){
            return s;
        }
        int maxL = 1;
        int start = 0;
        int end = 0;
        
        //from second to second to last
        for (int i = 1; i < l - 1; i++){
            if (a[i] != a[i - 1] && a[i] != a[i + 1]){
                int localLongest = check(a, i - 1, i + 1);
                if (2 * localLongest + 1 > maxL){
                    maxL = 2 * localLongest + 1;
                    start = i - localLongest;
                    end = i + localLongest;
                }
            }
            if (a[i] == a[i - 1] && a[i] == a[i + 1]){
                int localLongest = check(a, i - 1, i + 1);
                if (2 * localLongest + 1 > maxL){
                    maxL = 2 * localLongest + 1;
                    start = i - localLongest;
                    end = i + localLongest;
                }
            }
            if (a[i] == a[i - 1]){
                int localLongest = check(a, i - 2, i + 1);
                if (2 * localLongest + 2 > maxL){
                    maxL = 2 * localLongest + 2;
                    start = i - 1 - localLongest;
                    end = i + localLongest;
                }
            }
            if (a[i] == a[i + 1]){
                int localLongest = check(a, i - 1, i + 2);
                if (2 * localLongest + 2 > maxL){
                    maxL = 2 * localLongest + 2;
                    start = i - localLongest;
                    end = i + localLongest + 1;
                }
            }

        }
        return s.substring(start, end + 1);
    }
    
    //check the longest length substring the two gievn substring have
    //example: a[] = {1,2,3,4,3,2,1}
    //input: check{a, 2, 4} => check {1,2,3} and {3,2,1}
    //and return the length that longest conmon part
    //in above case return 3
    private int check(char[] a, int leftEnd, int rightStart){
        int l = a.length;
        if (0 > leftEnd || rightStart > l - 1){
            return 0;
        }
        if (a[leftEnd] == a[rightStart]){
            return 1 + check(a, leftEnd - 1, rightStart + 1);
        }
        return 0;
    }
}
