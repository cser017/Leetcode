class twoPointerSolution {
// Two pointer
// 
// at least the shortest side between
// level = min (Hl,Hr)
// fill between Hlmax, Hrax
// end when l = r
class Solution {
    public int trap(int[] height) {
        int sum = 0, lmax = 0, rmax = 0, l = 0, r = height.length - 1;
        while(l < r){
            // can only keep shortest
            if(height[l] < height[r]){
                lmax = Math.max(lmax, height[l]);
                sum += Math.max(0, lmax - height[l]);
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                sum += Math.max(0, rmax - height[r]);
                r--;
            }                  
        }        
        return sum;
    }
}  
}