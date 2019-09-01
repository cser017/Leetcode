class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, lp = 1;
        int[] res = new int[len], right = new int[len];
        for(int i = len - 1; i >= 0; i --){
            if(i != len - 1){
                right[i] = right[i + 1] * nums[i];
            } else{
                right[i] = nums[i];
            }
        }
        for(int j = 0; j < nums.length; j ++){
            if(j != nums.length - 1){
                res[j] = lp * right[j + 1];
            } else{
                res[j] = lp;
            }
            lp *= nums[j];
        }
        return res;
    }
}