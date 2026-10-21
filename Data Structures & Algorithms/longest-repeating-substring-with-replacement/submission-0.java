class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;
        while(r<n)
        {
            maxFreq = Math.max(maxFreq,++freq[s.charAt(r)-'A']);
            if(r-l+1 - maxFreq > k){
                freq[s.charAt(l++)-'A']--;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}
// AAABABBBB
// keep moving and move left when there is scope
// AAAABBBCCDDDDD
// len - maxl <= k



