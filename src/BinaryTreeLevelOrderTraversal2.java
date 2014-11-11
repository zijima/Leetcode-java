import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        
        Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>();
        List<TreeNode> rootLevel = new ArrayList<TreeNode>();
        rootLevel.add(root);
        stack.push(rootLevel);
        while(stack.peek().size() != 0){
            List<TreeNode> current = stack.peek();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for (TreeNode treeNode : current) {
                if(treeNode.left != null){
                    next.add(treeNode.left);
                }
                if(treeNode.right != null){
                    next.add(treeNode.right);
                }
            }
            stack.push(next);
        }
        stack.pop();
        while(!stack.empty()){
            List<TreeNode> currentTreeNodes = stack.pop();
            ArrayList<Integer> currentInts = new ArrayList<Integer>();
            for (TreeNode node : currentTreeNodes){
                currentInts.add(node.val);
            }
            result.add(currentInts);
        }
        return result;
    }
}
