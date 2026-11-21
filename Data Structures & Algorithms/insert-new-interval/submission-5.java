class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};
        List<int[]> newIntervals = new ArrayList<>(Arrays.asList(intervals));
        newIntervals.add(newInterval);
        for(int i=newIntervals.size()-2;i>=0;i--)
        {
            if(newIntervals.get(i)[0] > newIntervals.get(i+1)[0]){
                int tmp[] = newIntervals.get(i);
                newIntervals.set(i,newIntervals.get(i+1));
                newIntervals.set(i+1,tmp);
            }
        }
        // for(int i=0;i<=n;i++)
        // {
        //     System.out.println(newIntervals.get(i)[0]+" "+newIntervals.get(i)[1]);
        // }
        int cur_start = newIntervals.get(0)[0];
        int cur_end = newIntervals.get(0)[1];
        int i = 1;

        // System.out.println(cur_start +" "+ cur_end);
        while(i < newIntervals.size())
        {
            if(cur_end >= newIntervals.get(i)[0]){
                cur_end = Math.max(cur_end,newIntervals.get(i)[1]);
                newIntervals.set(i-1,new int[]{cur_start, cur_end});
                // System.out.println(cur_start +" "+ cur_end);
                newIntervals.remove(i);
            } else {
                cur_start = newIntervals.get(i)[0];
                cur_end = newIntervals.get(i)[1];
                i++;
            }
        }

        return newIntervals.toArray(int[][]::new);
    }
}
