class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int noOfQueries = queries.length;
        int sortedQueries[][] = new int[noOfQueries][2];
        for(int i=0;i<noOfQueries;i++)
        {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i,j) -> Integer.compare(intervals[i][1]-intervals[i][0]+1,intervals[j][1]-intervals[j][0]+1));
        int ans[] = new int[noOfQueries];
        int j=0;
        for(int i=0;i<noOfQueries;i++)
        {
            int query = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            while(j < n && intervals[j][0] <= query){
                minHeap.add(j++);
            }
            while(!minHeap.isEmpty() && intervals[minHeap.peek()][1] < query)
            {
                minHeap.poll();
            }
            ans[originalIndex] = minHeap.isEmpty() ? -1 : intervals[minHeap.peek()][1]-intervals[minHeap.peek()][0]+1;
        }
        return ans;
    }
}
