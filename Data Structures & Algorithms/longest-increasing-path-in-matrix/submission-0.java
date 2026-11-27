class Solution {
    public int solve(int i, int j, int[][] matrix, int[][] dp){
        if(i < 0 || j < 0 || i > matrix.length || j > matrix.length) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int moves[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int maxPath = 1;
        for(int k=0;k<4;k++)
        {
            int xi = i + moves[k][0], xj = j + moves[k][1];
            if((xi >=0 && xi < matrix.length) && (xj >=0 && xj < matrix[0].length) && (matrix[xi][xj] > matrix[i][j])){
                maxPath = Math.max(maxPath,1+solve(xi,xj,matrix,dp));
            }
        }
        dp[i][j]=maxPath;
        return maxPath;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        if(dp[i][j] == 0)
        ans = Math.max(ans,solve(i,j,matrix,dp));
        return ans;
    }
}
