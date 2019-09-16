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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        recursion(res, root);
        return res;
    }
    
    public void recursion(List<Integer> res, TreeNode root) {
        if(root == null){
            return;
        } 
        if(root.left != null){
            recursion(res, root.left);
        }
        res.add(root.val);
        if(root.right != null){
            recursion(res, root.right);
        }  
    }
}

/*
    1. have left child -> to stack
    2. No left child -> a. add to res  b. pop from stk and add to res  c. put right child (if any) to stk   

*/ 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();
        while(cur != null || !stk.isEmpty()){
            while(cur != null){
                stk.push(cur);
                cur = cur.left;
            } 
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}