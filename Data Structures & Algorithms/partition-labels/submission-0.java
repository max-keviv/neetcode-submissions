class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastPosition[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++)
        {
           lastPosition[ s.charAt(i)-'a' ] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        while(r<n){
            int c = s.charAt(r)-'a';
            int fartest = lastPosition[c];
            l = r;
            while(r <= fartest)
            {
                c = s.charAt(r)-'a';;
                fartest = Math.max(fartest,lastPosition[c]);
                r++;
            }
            ans.add(r-l);
        }
        return ans;
    }
}
