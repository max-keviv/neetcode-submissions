class Solution {
    public boolean isValid(int[] s_count, int[] t_count){
        for(int i=0;i<100;i++)
            if(t_count[i]>s_count[i]) return false;
        return true;
    }
    public String minWindow(String s, String t) {
        int[] s_count = new int[100];
        int[] t_count = new int[100];
        for(int i=0;i<s.length();i++)
            s_count[s.charAt(i)-'A']++;
        for(int i=0;i<t.length();i++)
            t_count[t.charAt(i)-'A']++;
        for(int i=0;i<100;i++)
            if(t_count[i]>s_count[i]) return "";
        int l = 0, r = 0, ans = Integer.MAX_VALUE, ind = 0;
        s_count = new int[100];
        while(r<s.length()){
            int i = s.charAt(r)-'A';
            s_count[i]++;
            while(isValid(s_count,t_count)){
                if(ans > r-l+1){
                    ans = r-l+1;
                    ind = l;
                }
                s_count[s.charAt(l++)-'A']--;
            }
            // System.out.println(r+" "+l);
            r++;
        }
        return s.substring(ind,ind+ans);
    }
}
