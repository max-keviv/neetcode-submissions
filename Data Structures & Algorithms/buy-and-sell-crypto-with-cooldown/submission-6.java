class Solution {
    public int solve(int i, int buying, int[] prices, int[][] dp)
    {
        if(i >= prices.length) return 0;
        if(dp[i][buying] != 0) return dp[i][buying];
        if(buying == 1)
        {
            dp[i][1] = Math.max(solve(i+1,0,prices,dp) - prices[i],solve(i+1,buying,prices,dp));
        }
        else{
            dp[i][0] = Math.max(solve(i+2,1,prices,dp) + prices[i],solve(i+1,buying,prices,dp));
        }
        return dp[i][buying];
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+3][2];
        for(int i=prices.length-1;i>=0;i--)
        {
            for(int buying=0;buying<=1;buying++)
            {
            if(buying == 1)
            {
                dp[i][1] = Math.max(dp[i+1][0] - prices[i],dp[i+1][buying]);
            }
            else{
                dp[i][0] = Math.max(dp[i+2][1] + prices[i],dp[i+1][buying]);
            }
            }
        }
        return dp[0][1];
    }
}
