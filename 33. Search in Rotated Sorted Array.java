/*
    key point: find is it in origin part or rotated part
        compare to the first element 
           
    if first > cur -> cur must in rotated array
        if(first >= target && cur < target) -> search right 
        else search left
    
    if last < cur  -> cur must in origin array
        if(last <= target && cur > target) search left
        else search right
*/ 

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid, cur;
        while(l <= r){
            mid = l + (r - l) / 2;
            cur = nums[mid];
            if(cur == target){
                return mid;
            } 
            if(cur < nums[0]){ // in rotated array
                if(target <= nums[nums.length - 1] && cur < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // must in origin array
                if(target >= nums[0] && cur > target) {
                   r = mid - 1;
                } else {
                   l = mid + 1;
                }
            }
        }
        return -1;
    }
}