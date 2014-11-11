import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    /*
     * use a helper function takes a list of integers and next node
     * 
    */
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        List<Integer> list = new LinkedList<Integer>();
        return helper(root, list);
    }
    
    private int helper(TreeNode node, List<Integer> list){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            list.add(node.val);
            int sum = getSum(list);
            list.remove(list.size() - 1);
            return sum;
        }
        list.add(node.val);
        int sum = helper(node.left, list) + helper(node.right, list);
        list.remove(list.size() - 1);
        return sum;
    }
    
    private int getSum(List<Integer> list){
        int result = 0;
        for (Integer i : list){
            result = result * 10 + i;
        }
        return result;
    }
}
