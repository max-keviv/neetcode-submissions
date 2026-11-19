class Solution {
    public int maxRobAmount(int i,int[] nums,int[] dp)
    {
        if(i>nums.length+1) return 0;
        if(dp[i] != 0) return dp[i];
        int snd = maxRobAmount(i+2,nums,dp);
        int third = maxRobAmount(i+3,nums,dp);
        dp[i] = (i - 2 < 0 ? 0 : nums[i-2]) + Math.max(snd,third);
        return dp[i];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+5];
        int n = nums.length;
        dp[n+4]=0;
        dp[n+3]=0;
        for(int i=n+1;i>=0;i--)
        {
            int snd = dp[i+2];
            int third = dp[i+3];
            dp[i] = (i - 2 < 0 ? 0 : nums[i-2]) + Math.max(snd,third);
        }
        return dp[0];
    }
}

// 0 1 2 3 4
// 0 2 4
// 0 3
// 1 3
// 1 4