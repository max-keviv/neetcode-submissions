class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int count[] = new int[26];
       for(int i=0;i<s1.length();i++)
       {
        count[s1.charAt(i)-'a']++;
       }
       int l = 0, r = 0;
       int iterCounter[] = new int[26];
       while(r<s2.length())
       {
        int it = s2.charAt(r)-'a';
        iterCounter[it]++;
        while(iterCounter[it] > count[it]){
            --iterCounter[s2.charAt(l++)-'a'];
        }
        if(r-l+1 == s1.length()) return true;
        r++;
       }
       return false;
    }
}
