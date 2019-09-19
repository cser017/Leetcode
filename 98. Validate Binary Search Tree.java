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
    public boolean isValidBST(TreeNode root) {
        return travel(root, null, null);
    }
    
    public boolean travel(TreeNode root, Integer lower, Integer upper) {
        if(root == null){
            return true;
        }
        if(upper != null && root.val >= upper){
            return false;
        }
        if(lower != null && root.val <= lower){
            return false;
        }
        return travel(root.left, lower, root.val) && travel(root.right, root.val, upper);
    }
}