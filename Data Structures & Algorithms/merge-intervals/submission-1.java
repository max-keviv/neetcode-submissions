class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> nonOverLappingIntervals = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        for(int i=0;i<n;i++)
        {
            if(nonOverLappingIntervals.size() == 0){
                nonOverLappingIntervals.add(intervals[0]);
                continue;
            }
            int size = nonOverLappingIntervals.size();
            int lastInterval[] = nonOverLappingIntervals.get(size-1);
            int currInterval[] = intervals[i];
            if(lastInterval[1] >= currInterval[0]){
                currInterval[0] = Math.min(currInterval[0],lastInterval[0]);
                currInterval[1] = Math.max(currInterval[1],lastInterval[1]);
                nonOverLappingIntervals.remove(size-1);
            }
            nonOverLappingIntervals.add(currInterval);
        }
        return nonOverLappingIntervals.toArray(int[][]::new);
    }
}

// [1,2],[3,4],[5,6]
// [1,3] [2,4] [3,6]