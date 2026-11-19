class Solution {
    public int robMaxAmount(int pos,int offset, int[] nums, int[][] dp){
        int n = nums.length;
        if(pos >= n-offset) return 0;
        if(dp[pos][offset] != 0) return dp[pos][offset];
        int snd = robMaxAmount(pos+2,offset,nums,dp);
        int trd = robMaxAmount(pos+3,offset,nums,dp);
        dp[pos][offset] = nums[pos] + Math.max(snd,trd);
        return dp[pos][offset];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][2];
        if(n==1) return nums[0];
        return Math.max(robMaxAmount(0,1,nums,dp),Math.max(robMaxAmount(1,0,nums,dp),robMaxAmount(2,0,nums,dp)));
    }
}

// 1   -> one
// 1 2 -> one
// 1 2 3 -> one
// 1 2 3 4 -> two (1,3) or (2,4)
// 1 2 3 4 5 -> two (1,4) or (2,4) or (2,5) or (1,3,5)
