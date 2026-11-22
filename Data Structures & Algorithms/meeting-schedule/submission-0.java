/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Arrays.sort(intervals,(a,b) -> (Integer.compare(a[0],b[0])));
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));
        int n = intervals.size();
        if(n==0) return true;
        
        for(int i=1;i<n;i++){
            if(intervals.get(i).start < intervals.get(i-1).end) return false;
        }
        return true;
    }
}
