/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArray2BST {
    public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length);
    }
    private TreeNode helper(int[] num, int start, int end){
        if (start >= end){
            return null;
        }
        
        int mid = (end + start) / 2;
        TreeNode result = new TreeNode(num[mid]);
        result.left = helper(num, start, mid);
        result.right = helper(num, mid + 1, end);
        return result;
    }
}
