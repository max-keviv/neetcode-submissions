class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        int l = 0, ans = 0;
        for(int i=0;i<s.length();i++)
        {
            charCount.put(s.charAt(i),charCount.getOrDefault(s.charAt(i),0)+1);
            while(charCount.get(s.charAt(i)) > 1){
                charCount.put(s.charAt(l),charCount.get(s.charAt(l))-1);
                l++;
            }
            ans = Math.max(ans,i-l+1);
        }
        return ans;
    }
}
