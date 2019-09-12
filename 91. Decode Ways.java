class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int cur = 1, pre = 1, tmp = 1;
        for(int i = 1; i < s.length(); i ++){
            if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2' && s.charAt(i) == '0'){
                return 0;
            }
            if(s.charAt(i) == '0'){
                cur = tmp;
            } else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' < 7)){
                cur = pre + tmp;
            }
            tmp = pre;
            pre = cur;
        }
        return cur;
    }
}