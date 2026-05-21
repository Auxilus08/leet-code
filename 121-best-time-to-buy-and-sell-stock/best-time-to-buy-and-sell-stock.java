class Solution {
    public int maxProfit(int[] prices) {
        int minP = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            minP = Math.max(minP, prices[i] - min);
        }

        return minP;
    }
}