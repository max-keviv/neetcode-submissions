class Solution {
    public int lcs(int i, int j, String text1, String text2, int[][] dp){
        if(i < 0) return 0;
        if(j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int take = text1.charAt(i) == text2.charAt(j) ? 1 + lcs(i-1,j-1,text1,text2,dp) : 0;
        int notTake = Math.max(lcs(i-1,j,text1,text2,dp),lcs(i,j-1,text1,text2,dp));
        dp[i][j] = Math.max(take,notTake);
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        // return lcs(n,m,text1,text2,dp);
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                int take = text1.charAt(i-1) == text2.charAt(j-1) ? 1 + dp[i-1][j-1] : 0;
                int notTake = Math.max(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[n][m];
    }
}
