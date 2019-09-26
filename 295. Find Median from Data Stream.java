class MedianFinder {
    class TreeNode{
        int val;
        TreeNode left, right, parent;
        TreeNode(int v, TreeNode p){
            val = v;
            parent = p;
        }
        
        void add(int num){
            if(num >= val){
                if(right == null){
                    right = new TreeNode(num, this);
                } else {
                    right.add(num);
                }
            } else {
                if(left == null){
                    left = new TreeNode(num, this);
                } else {
                    left.add(num);
                }
            }
        }
        
        TreeNode next(){
            TreeNode res;
            if(right != null){
                res = right;
                while(res.left != null){
                    res = res.left;
                }
            } else {
                res = this;
                while(res.parent.right == res){
                    res = res.parent;
                }
                res = res.parent;
            }
            return res;
        }
        
        TreeNode prev(){
            TreeNode res;
            if(left != null){
                res = left;
                while(res.right != null){
                    res = res.right;
                }
            } else {
                res = this;
                while(res.parent.left == res){
                    res = res.parent;
                }
                res = res.parent;
            }
            return res;
        }
    }
    
    TreeNode root, curr;
    int size;
    /** initialize your data structure here. */
    
    public void addNum(int num) {
        if(root == null){
            root = new TreeNode(num, null);
            curr = root;
            size = 1;
        } else {
           size ++; 
           root.add(num);
           if(size % 2 == 1 ) {
               if(num >= curr.val){
                   curr = curr.next();
               }               
           } else if(num < curr.val){
               curr = curr.prev();         
           }
        }        
    }
    
    public double findMedian() {
        if(size % 2 == 1){
            return curr.val;
        } else {
            return (curr.val + curr.next().val) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */