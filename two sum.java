//https://leetcode.com/submissions/detail/253748639/

// constrains: sum overflow? 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }
            if(map.containsKey(nums[i])){ 
                continue;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}