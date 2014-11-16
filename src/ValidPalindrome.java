/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("asd dsa"));
		System.out.println(vp.isPalindrome("asdedsa"));
		System.out.println(vp.isPalindrome("as      d ds a"));
		System.out.println(vp.isPalindrome("....."));
		System.out.println(vp.isPalindrome("asdasdsa"));
	}
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        char[] c = s.toLowerCase().toCharArray();
        int l = c.length;
        if (l == 0){
            return true;
        }
        int i = 0;
        int j = l - 1;
        while (i < j){
            char ci = c[i];
            char cj = c[j];
            if (!isValidChar(ci)){
                i++;
                continue;
            }
            if (!isValidChar(cj)){
                j--;
                continue;
            }
            if (ci == cj){
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
    
    private boolean isValidChar(char cj){
        return (cj >= 'a' && cj <= 'z' || cj >= 'A' && cj <= 'Z' || cj >= '0' && cj <= '9');
    }
}
