class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int ans = 0, n = intervals.length;
        if(n==0) return 0;
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(end > intervals[i][0]){
                ans++;
                continue;
            }
            end = intervals[i][1];
        }
        return ans;
    }
}

//  