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
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // if(amount == 0) return ;
        Arrays.sort(coins);
        int dp[][] = new int[n][amount+2];
        return solve(coins.length-1,amount,coins,dp);
    }
}
