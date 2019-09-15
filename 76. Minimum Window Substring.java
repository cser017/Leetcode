/*
    use map and compare cnt
        1.l, r start from 0
        2.move right index till contain all chars or reach end
        3.Move left index till not contains all chars.  record len for previous,
        4.Repeat
*/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return "";
        }
        
        // parse t
        // char -> count
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i ++){
            char ch = t.charAt(i);
            int count = map.getOrDefault(ch, 0);           
            map.put(ch, count + 1);    
        }
        
        // cnt unique chars in map
        int cnt_required = map.size(), cnt_have = 0, l = 0, r = 0;
        HashMap<Character, Integer> windowCnt = new HashMap<>();
        // len, left index, right index
        int[] res = {-1, 0, 0};
        
        while(r < s.length()){
            char c = s.charAt(r);
            int count = windowCnt.getOrDefault(c, 0);
            windowCnt.put(c, count + 1);
            
            if(map.containsKey(c) && windowCnt.get(c).intValue() == map.get(c).intValue()) {
                cnt_have ++;
            }
        
            while(l <= r && cnt_have == cnt_required){
                c = s.charAt(l);
                if(res[0] == -1 || r - l + 1 < res[0]){
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }
                // remove c from window
                // right index has gone through it so it must exist
                windowCnt.put(c, windowCnt.get(c) - 1);
                if(map.containsKey(c) && windowCnt.get(c).intValue() < map.get(c).intValue()) {
                    cnt_have --;
                }
                
                l ++;
            }
            
            r ++;                  
        }
        
        return res[0] == -1? "" : s.substring(res[1], res[2] + 1);
    }
}