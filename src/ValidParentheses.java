import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *  determine if the input string is valid.
 *  The brackets must close in the correct order, 
 *  "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null){
            return false;
        }
        if(s.length() <= 1){
            return false;
        }
        Stack<Character> open = new Stack<Character>();
        int l = s.length();
        for(int i = 0; i < l; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                open.push(c);
                continue;
            }  
            
            if(open.size() == 0){
                return false;
            }
            
            char cc = open.peek();
            if((cc == '(' && c == ')') || (cc == '{' && c == '}') || (cc == '[' && c == ']')){
                open.pop();
            } else {
                return false;
            }
        }
        if (open.size() != 0){
            return false;
        }
        return true;
    }
}
