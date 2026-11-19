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
        int dp[] = new int[nums.length+3];
        return maxRobAmount(0,nums,dp);
    }
}

// 0 1 2 3 4
// 0 2 4
// 0 3
// 1 3
// 1 4