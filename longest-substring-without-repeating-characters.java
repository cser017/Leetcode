// hash set
// restart left pointer each dup

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){ 
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            } 
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}