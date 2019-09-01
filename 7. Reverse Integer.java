class Solution {
    public int reverse(int x) {
        int res = 0, digit = 0;
        while(x != 0){
            digit = x % 10;
            // because input is int, digit won't mater in this problem
            // if input is string, we need to consider last digit
            if((res < 0 && res < Integer.MIN_VALUE/10) || (res > 0 && res > Integer.MAX_VALUE/10)){
                return 0;
            }
            res *= 10;
            res += digit;
            x = x/10;
        }
        return res;
    }
}