/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        findDepth(root);
        return res - 1;
    }
    
    public int findDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}