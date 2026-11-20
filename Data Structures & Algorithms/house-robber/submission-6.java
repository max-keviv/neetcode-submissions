class Solution {
    public int solve(int i,int[] nums,int[] dp)
    {
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=0) return dp[i];
        
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[1] = nums[0];
        for(int i=2;i<=n;i++)
        {
        int take = nums[i-1] + dp[i-2];
        int notTake = dp[i-1];
        dp[i] = Math.max(take,notTake);
        }
        return dp[n];
    }
}
