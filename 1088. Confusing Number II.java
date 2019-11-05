class Solution {
    
    int[] rotates = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    int[] digits = {0,1,6,8,9};
    int res;
    
    public int confusingNumberII(int N) {
        res = 0;
        dfs(0, 0, N);
        return res;
    }
    
    public void dfs(int cnt, int cur, int n) {
        if(cnt > 9 || cur > n){
            return;
        }
        if(n == 1000000000){
            res ++;
            n --;
        }
        
        if(isConfusingNumber(cur)){
            res ++;
        }
        for(int d : digits){
            if(d == 0 && cur == 0) continue;
            dfs(cnt + 1, cur * 10 + d, n);
        }
    }
    
    public boolean isConfusingNumber(int n) {
        int rot = 0, copy = n;
        
        while(copy != 0){
            int mod = copy % 10;
            if(rotates[mod] < 0){
                return false;
            }
            copy = copy / 10;
            rot = rot * 10 + rotates[mod];
        }
        return rot != n;
    }
}