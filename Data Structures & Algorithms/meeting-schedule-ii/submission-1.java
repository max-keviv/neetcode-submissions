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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(a,b));
        int ans = 0;
        for(int i=0;i<intervals.size();i++)
        {
            while(!minHeap.isEmpty() && minHeap.peek() <= intervals.get(i).start){
                minHeap.poll();
            }
            minHeap.add(intervals.get(i).end);
            ans = Math.max(ans,minHeap.size());
        }
        return ans;
    }
}
