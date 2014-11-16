import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
 
    	if (s == null || s.length() == 0) {
    		return result;
    	}
     
    	List<String> partition = new ArrayList<String>();
    	addPalindrome(s, 0, partition, result);
     
    	return result;
    }
    
    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result){
        if (start == s.length()){
        	List<String> temp = new ArrayList<String>(partition);
		    result.add(temp);
	    	return;
        }
        
        for (int i = start + 1; i <= s.length(); i++){
            String sub = s.substring(start, i);
            if (isPalindrome(sub)){
                partition.add(sub);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
    	int left = 0;
    	int right = str.length() - 1;
     
    	while (left < right) {
    		if (str.charAt(left) != str.charAt(right)) {
    			return false;
    		}
     
    		left++;
    		right--;
    	}
     
    	return true;
    }
}
