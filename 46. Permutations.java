class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int num : nums) {
            ans.add(num);
        }
        backtracking(ans, res, 0);
        return res;
    }
    
    public void backtracking(List<Integer> ans, List<List<Integer>> res, int first) {
        int n = ans.size();
        if(first == n) {
            res.add(new ArrayList<Integer>(ans));
        }
        for(int i = first; i < n; i ++){
            Collections.swap(ans, first, i);
            backtracking(ans, res, first + 1);
            Collections.swap(ans, first, i);
        }
    }
}