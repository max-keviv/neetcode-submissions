class Solution {
    public int solve(int i, int bought, int[] prices, int[][] dp){
    if(i > prices.length) return 0;
    int maxProfit = 0;
    if(dp[i][bought] != 0) return dp[i][bought];
    if(bought == 0){
        maxProfit = Math.max(solve(i+1,i,prices,dp),solve(i+1,bought,prices,dp));
    }
    else{
       maxProfit = Math.max(prices[i-1] -  prices[bought-1] + solve(i+2,0,prices,dp), solve(i+1,bought,prices,dp));
    }
    dp[i][bought] = maxProfit;
    return maxProfit;
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+3][prices.length+3];
        // return solve(1,0,prices,dp);
        for(int i=prices.length;i>0;i--)
        {
            for(int bought=prices.length;bought>=0;bought--)
            {
                int maxProfit = 0;
                if(bought == 0){
                    maxProfit = Math.max(dp[i+1][i],dp[i+1][bought]);
                }
                else{
                    maxProfit = Math.max(prices[i-1] -  prices[bought-1] + dp[i+2][0], dp[i+1][bought]);
                }
                dp[i][bought] = maxProfit;
            }
        }
        return dp[1][0];
    }
}
