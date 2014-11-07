import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }
    public void helper(List<Integer> list, TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
    
    //////
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
    	    return result;
    	}
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
