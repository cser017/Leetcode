class Solution {
    public int maxArea(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        while(l < r){
            res = Math.max(res, Math.min(lmax, rmax) * (r - l));
            if(lmax > rmax) {
                r --;
                rmax = height[r];     
            } else {
                l ++;
                lmax = height[l];      
            }
            
        }
        return res;
    }
}