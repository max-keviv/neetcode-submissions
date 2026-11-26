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
        int dp[][] = new int[prices.length+2][prices.length+2];
        return solve(1,0,prices,dp);
        // dp[1] = prices[0];
        // for(int i=2;i<=prices.length+1;i++)
        // {
        //     int take = prices[i-2] + dp[i-2];
        //     int notTake = dp[i-1];
        //     dp[i] = Math.max(take,notTake);
        // }
        // return
    }
}
