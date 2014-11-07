import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }
    public void helper(List<Integer> list, TreeNode root) {
        if (root == null){
            return;
        }
        
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
