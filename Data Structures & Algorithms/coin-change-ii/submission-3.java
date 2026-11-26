class Solution {
    public int solve(int i, int amount, int[] coins, int[][] dp)
    {
        if(i<0) return 0;
        if(amount == 0) return 1; 
        if(dp[i][amount] != 0) return dp[i][amount];
        int noOfWays = amount >= coins[i] ? solve(i,amount-coins[i],coins,dp)+solve(i-1,amount,coins,dp) : solve(i-1,amount,coins,dp);
        dp[i][amount] = noOfWays; 
        return dp[i][amount];
    }
    public int change(int target, int[] coins) {
        int n = coins.length;
        // if(amount == 0) return ;
        Arrays.sort(coins);
        int dp[][] = new int[n][target+2];
        // return solve(coins.length-1,amount,coins,dp);
        for(int i=0;i<n;i++)
        {
            for(int amount=0;amount<=target;amount++)
            {
                if(amount == 0)
                {
                    dp[i][amount] = 1;
                    continue;
                }
                int noOfWays = amount >= coins[i] ? (amount-coins[i] < 0 ? 0 : dp[i][amount-coins[i]]) + (i == 0 ? 0 : dp[i-1][amount]) : i == 0 ? 0 : dp[i-1][amount];
                dp[i][amount] = noOfWays; 
            }
        }
        return dp[n-1][target];
    }
}
