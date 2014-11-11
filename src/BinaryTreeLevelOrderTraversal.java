import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> results = new LinkedList<List<TreeNode>>();
        List<List<Integer>> returnResult = new LinkedList<List<Integer>>();
        if (root == null){
            return returnResult;
        }
        List<TreeNode> last = new LinkedList<TreeNode>();
        last.add(root);
        results.add(last);
        
        List<TreeNode> newLevel;
        
        while (last.size() != 0) {
            newLevel = new LinkedList<TreeNode>();
            for (TreeNode node : last){
                if (node.left != null){
                    newLevel.add(node.left);
                }
                if (node.right != null){
                    newLevel.add(node.right);
                }
            }
            results.add(newLevel);
            last = newLevel;
        }
        
        for (List<TreeNode> list : results){
            if (list.size() == 0){
                continue;
            }
            List<Integer> re = new LinkedList<Integer>();
            for (TreeNode node : list){
                re.add(node.val);
            }
            returnResult.add(re);
        }
        
        return returnResult;
    }
}
