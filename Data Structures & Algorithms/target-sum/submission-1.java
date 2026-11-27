class Solution {
    public int solve(int i, int total, int[] nums, int target, int[][] dp){
        if(i >= nums.length) return total == target ? 1 : 0;
        if(dp[i][total] != 0)
        {
            return dp[i][total];
        }
        int add = solve(i+1,total+nums[i],nums,target,dp);
        int sub = solve(i+1,total-nums[i],nums,target,dp);
        dp[i][total]=add+sub;
        return dp[i][total];
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum+=num;
        int dp[][] = new int[n+1][sum+sum+1];
        return solve(0,sum,nums,sum+target,dp);
    }
}
