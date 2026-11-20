class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left--) == s.charAt(right++)){
                ans++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left--) == s.charAt(right++)){
                ans++;
            }
        }
        return ans;
    }
}

//  -1 1 => 1
// -1 0 1 2 3 => 4
//  0 1 2 3 4 5 6 => 

//  