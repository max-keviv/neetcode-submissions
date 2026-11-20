class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0, res = 0, n = s.length();
        for(int i=0;i<n;i++)
        {
            int d=0;
            while(i-d>=0 && i+d<n && s.charAt(i-d) == s.charAt(i+d))
            {
                d++;
            }
            d--;
            if(resLen < 2*d+1) {
                resLen = 2*d+1;
                res = i-d;
            }
            d=0;
            while(i-d>=0 && i+d+1<n && s.charAt(i-d) == s.charAt(i+d+1))
            {
                d++;
            }
            d--;
            if(resLen < 2*(d+1)) {
                resLen = 2*(d+1);
                res = i-d;
            }
        }
        return s.substring(res,res+resLen);
    }
}

