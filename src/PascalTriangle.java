import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PascalTriangle {
    public List<List<Integer>> generateRecursive(int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (n == 0){
            return result;
        }
        List<Integer> nl = new LinkedList<Integer>();
        nl.add(1);
        result.add(nl);
        
        helper(result, 2, n);
        
        return result;
    }
    
    private void helper(List<List<Integer>> list, int current, int n){
        if (n < current){
            return;
        }
        List<Integer> newLevel = new LinkedList<Integer>();
        List<Integer> lastLevel = list.get(current - 2);
        newLevel.add(1);
        for (int i = 0; i < lastLevel.size() - 1; i++){
            newLevel.add(lastLevel.get(i) + lastLevel.get(i + 1));
        }
        newLevel.add(1);
        list.add(newLevel);
        
        helper(list, current + 1, n);
    }
    
    public ArrayList<ArrayList<Integer>> generateIterative(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == 0){
            return result;
        }
        
        for (int i = 0; i < num; i++){
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    level.add(1);
                    continue;
                }
                if(i != 0){
                    ArrayList<Integer> last = result.get(i - 1);
                    level.add(last.get(j - 1) + last.get(j));
                }
            }
            result.add(level);
        }
        return result;
    }
}
