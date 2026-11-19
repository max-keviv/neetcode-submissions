class Solution {
    int dp(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n] = dp(n-1,dp)+dp(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for(int i=2;i<=n;i++)
        {
            int next = one + two;
            one = two;
            two = next;
        }

        return two;
    }
}
