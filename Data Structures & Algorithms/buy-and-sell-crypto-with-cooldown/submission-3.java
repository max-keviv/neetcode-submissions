class Solution {
    public int solve(int i, boolean buying, int[] prices, int[][] dp)
    {
        if(i >= prices.length) return 0;
        if(buying)
        {
            if(dp[i][0] != 0) return dp[i][0];
            dp[i][0] = Math.max(solve(i+1,!buying,prices,dp) - prices[i],solve(i+1,buying,prices,dp));
            return dp[i][0];
        }
        else{
            if(dp[i][1] != 0) return dp[i][1];
            dp[i][1] = Math.max(solve(i+2,!buying,prices,dp) + prices[i],solve(i+1,buying,prices,dp));
            return dp[i][1];
        }

    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        return solve(0,true,prices,dp);
    }
}
