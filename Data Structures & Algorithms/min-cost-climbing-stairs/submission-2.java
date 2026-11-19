class Solution {
    int findMinClimbingStairsCost(int i,int[] cost,int[] dp)
    {
        if(i>cost.length) return 0;
        if(dp[i]!=0) return dp[i];
        
        int oneStep = findMinClimbingStairsCost(i+1,cost,dp);
        int twoStep = findMinClimbingStairsCost(i+2,cost,dp);
        dp[i] = (i == 0 ? 0 : cost[i-1])  + Math.min(oneStep,twoStep);
        return dp[i];
        
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        return findMinClimbingStairsCost(0,cost,dp);
    }
}
