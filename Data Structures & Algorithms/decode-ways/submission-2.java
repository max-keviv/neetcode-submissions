class Solution {
    public int decode(String s, int n, int[] dp) {
        if(n==0) return 1;
        if(n==1) return s.charAt(n-1) == '0' ? 0 : 1;
        if(dp[n] != 0) return dp[n];
        int one = s.charAt(n-1) - '0';
        int two = (s.charAt(n-2) - '0') * 10 + one;
        int ways = 0;
        if ( one != 0) ways += decode(s,n-1,dp);
        if ( two > 9 && two <= 26) ways += decode(s,n-2,dp);
        dp[n] = ways;
        return dp[n];
    }
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        return decode(s,n,dp);
    }
}
