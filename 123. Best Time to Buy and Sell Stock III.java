class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int firstBuy = Integer.MAX_VALUE, firstSell = 0, secondBuy = Integer.MAX_VALUE, secondSell = 0;
        for(int p : prices){
            firstBuy = Math.min(firstBuy, p);
            firstSell = Math.max(firstSell, p - firstBuy);
            secondBuy = Math.min(secondBuy, p - firstSell);
            secondSell = Math.max(secondSell, p - secondBuy);
        }
        return secondSell;
    }
}