class Solution {
    int dp(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        dp[n] = dp(n-1,dp)+dp(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++) dp[i] = -1;
        return dp(n,dp);
    }
}
