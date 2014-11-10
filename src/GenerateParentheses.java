import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        List<String> result = new ArrayList<String>();
        generate(result, "", n, n);
        return result;
    }
    
    void generate(List<String> list, String str, int left, int right){
        if(left == 0 && right == 0){
            list.add(str);
            return;
        }
        
        if(left == right){
            generate(list, str + "(", left - 1, right);
            return;
        }
        
        if(left > 0){
            generate(list, str + "(", left - 1, right);
        }
        
        
        generate(list, str + ")", left, right - 1);
        return;
    }
}
