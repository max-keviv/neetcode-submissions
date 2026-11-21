class Solution {
    public int lis(int prev, int cur, int[] nums, int[][] dp){
        if(cur > nums.length) return 0;
        if(dp[prev][cur] != -1) return dp[prev][cur];
        int take = prev == 0 || nums[prev-1] < nums[cur-1] ? 1 + lis(cur,cur+1,nums,dp) : 0;
        int notTake = lis(prev,cur+1,nums,dp);
        dp[prev][cur] = Math.max(take,notTake);
        return dp[prev][cur];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                dp[i][j] = -1;
        return lis(0,1,nums,dp);
    }
}