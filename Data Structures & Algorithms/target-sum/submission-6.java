class Solution {
    public int solve(int i, int total, int[] nums, int target, int[][] dp){
        if(i >= nums.length) return total == target ? 1 : 0;
        
        int add = solve(i+1,total+nums[i],nums,target,dp);
        int sub = solve(i+1,total-nums[i],nums,target,dp);
        dp[i][total]=add+sub;
        return dp[i][total];
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum+=num;
        if(Math.abs(target) > sum) return 0;
        int dp[][] = new int[n+1][2*sum+1];
        dp[n][sum+target]=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int index=2*sum;index>=0;index--)
            {
                int add = index+nums[i] > 2*sum ? 0 : dp[i+1][index+nums[i]];
                int sub = index-nums[i] < 0 ? 0 : dp[i+1][index-nums[i]];
                dp[i][index]=add+sub;
            }
        }
        return dp[0][sum];
    }
}
