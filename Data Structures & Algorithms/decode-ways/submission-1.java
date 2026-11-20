class Solution {
    public int decode(String s, int[] dp) {
        if(s.matches("0")) return 0;
        if(s.length() <= 1) return 1;
        if(dp[s.length()] != 0) return dp[s.length()];
        Integer one = Integer.parseInt(s.substring(s.length()-1));
        Integer two = Integer.parseInt(s.substring(s.length()-2));
        dp[s.length()] = (one == 0 ? 0 : decode(s.substring(0,s.length()-1),dp)) + (two <= 9 || two > 26 ? 0 : decode(s.substring(0,s.length()-2),dp));
        return dp[s.length()];
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        return decode(s,dp);
    }
}
