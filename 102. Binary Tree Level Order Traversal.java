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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0, cnt = 0;
        while(!q.isEmpty()){
            res.add(new LinkedList<Integer>());
            cnt = q.size();
            for(int i = 0; i < cnt; i ++){
                TreeNode cur = q.remove();
                res.get(level).add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            } 
            level ++;
        }
        
        return res;
    }
}