class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty() || s.length() < t.length()) return "";

        int[] needed = new int[128];
        for(int i=0;i<t.length();i++)
        {
            needed[t.charAt(i)]++;
        }
        int l = 0, r = 0, ans = Integer.MAX_VALUE, ind = 0, missing = t.length();
        while(r<s.length()){
            int added = s.charAt(r);
            if(needed[added] > 0)
            {
                missing--;
            }
            needed[added]--;
            while(missing==0)
            {
                if(ans > r - l + 1)
                {
                    ans = r - l + 1;
                    ind = l;
                }
                int removed = s.charAt(l);
                needed[removed]++;
                if(needed[removed]>0) missing++;
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ind,ind+ans);
    }
}
