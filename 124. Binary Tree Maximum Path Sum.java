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
    
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPathForNode(root);
        return res;
    }
    
    public int maxPathForNode(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(maxPathForNode(root.left), 0);
        int right = Math.max(maxPathForNode(root.right), 0);
        
        res = Math.max(res, root.val + left + right);
        
        return root.val + Math.max(left, right);       
    }
}