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
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
