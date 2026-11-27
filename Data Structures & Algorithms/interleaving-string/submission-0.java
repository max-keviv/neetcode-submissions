class Solution {
    public boolean match(int i, int j, String s1, String s2, String s3,int[][] dp)
    {
        if(i == s1.length() && j == s2.length()) return true;
        if(dp[i][j] != 0) return dp[i][j] == 1 ? true : false;
        boolean matchS1 = i < s1.length() && s1.charAt(i) == s3.charAt(i+j) ? match(i+1,j,s1,s2,s3,dp) : false;
        boolean matchS2 = j < s2.length() && s2.charAt(j) == s3.charAt(i+j) ? match(i,j+1,s1,s2,s3,dp) : false;
        dp[i][j] = matchS1 || matchS2 ? 1 : -1;
        return matchS1 || matchS2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        return match(0,0,s1,s2,s3,dp);
    }
}
