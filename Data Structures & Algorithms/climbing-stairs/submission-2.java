class Solution {
    int dp(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n] = dp(n-1,dp)+dp(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
