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
        int n = text1.length()-1;
        int m = text2.length()-1;
        int dp[][] = new int[n+1][m+1];
        return lcs(n,m,text1,text2,dp);
    }
}
