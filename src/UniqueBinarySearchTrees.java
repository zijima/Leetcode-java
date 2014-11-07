/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(i == 1 || i == n){
                count += numTrees(n - 1);
                continue;
            }
            int before = i - 1;
            int after = n - i;
            count = count + numTrees(before) * numTrees(after);
        }
        return count;
    }
}
