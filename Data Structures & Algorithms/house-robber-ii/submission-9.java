class Solution {
    int solve(int i,int[] nums,int[] dp){
        if(i<0) return 0;
        if(dp[i] != 0) return dp[i];
        int take = nums[i] + solve(i-2,nums,dp);
        int notTake = solve(i-1,nums,dp);
        dp[i] = Math.max(take,notTake);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int withoutFirstElem[] = new int[n-1];
        int withoutLastElem[] = new int[n-1];
        int dp1[] = new int[n-1];
        int dp2[] = new int[n-1];
        for(int i=0;i<n;i++)
        {
            if(i!=0) withoutFirstElem[i-1] = nums[i];
            if(i!=n-1) withoutLastElem[i] = nums[i];
        }

        return Math.max(solve(n-2,withoutFirstElem,dp1),solve(n-2,withoutLastElem,dp2));
    }
}
