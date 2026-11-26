class Solution {
    public int paths(int i, int j, int[][] dp)
    {
        if(i<0 || j<0) return 0;
        if(i==0&&j==0) return 1;
        if(dp[i][j] != 0) return dp[i][j];
        dp[i][j] = paths(i-1,j,dp) + paths(i,j-1,dp);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        return paths(m-1,n-1,dp);
    }
}
