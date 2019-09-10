/*

We have Cn results to return: https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0

*/ 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n > 0){
            backTracking(res,"", n, 0, 0);
        }
        return res;
    }
    
    public void backTracking(List<String> res, String s, int n, int left, int right) {
        if(s.length() == 2 * n){
            res.add(s);
            return;
        }
        // add (
        if(left < n) {
            backTracking(res, s + "(", n, left + 1, right);
        } 
        // add )
        if(left > right) {
            backTracking(res, s + ")", n, left, right + 1);
        }
    }
}