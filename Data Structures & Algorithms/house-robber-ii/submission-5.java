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
        int dp[][] = new int[n+3][2];
        if(n==1) return nums[0];

        for(int offset=0;offset<2;offset++){
            for(int pos=n-1-offset;pos>=0;pos--)
            {
                int snd = dp[pos+2][offset];
                int trd = dp[pos+3][offset];
                dp[pos][offset] = nums[pos] + Math.max(snd,trd);
            }
        }
        return Math.max(dp[0][1],Math.max(dp[1][0],dp[2][0]));
    }
}

// 1   -> one
// 1 2 -> one
// 1 2 3 -> one
// 1 2 3 4 -> two (1,3) or (2,4)
// 1 2 3 4 5 -> two (1,4) or (2,4) or (2,5) or (1,3,5)
