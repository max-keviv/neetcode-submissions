class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int q_len = queries.length;
        Map<Integer,List<Integer>> queryToPosition = new HashMap<>();
        for(int i=0;i<q_len;i++)
        {
            if(queryToPosition.get(queries[i]) == null) queryToPosition.put(queries[i],new ArrayList<>());
            queryToPosition.get(queries[i]).add(i);
        }
        Arrays.sort(queries);
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
        PriorityQueue<Integer> minLength = new PriorityQueue<>((a,b) -> Integer.compare(intervals[a][1]-intervals[a][0]+1,intervals[b][1]-intervals[b][0]+1));
        PriorityQueue<Integer> nearestEndingInterval = new PriorityQueue<>((a,b) -> Integer.compare(intervals[a][1],intervals[b][1]));
        Map<Integer,Boolean> invalidInterval = new HashMap<>();
        int query = 0;
        int curr = 0;
        int lengthOfShortestInterval[] = new int[q_len];
        while(query < q_len){

            while(curr < n && intervals[curr][0] <= queries[query]){
                int start = intervals[curr][0];
                int end = intervals[curr][1];
                if(queries[query] <= intervals[curr][1]){
                minLength.add(curr);
                nearestEndingInterval.add(curr);
                }
                curr++;
            }
            while(!minLength.isEmpty() && invalidInterval.getOrDefault(minLength.peek(),false)){
                minLength.poll();
            }
            if(minLength.isEmpty()){

                List<Integer> pos = queryToPosition.get(queries[query]);
                lengthOfShortestInterval[pos.get(pos.size()-1)] = -1;
                pos.remove(pos.size()-1);
            }
            else {
                List<Integer> pos = queryToPosition.get(queries[query]);
                lengthOfShortestInterval[pos.get(pos.size()-1)] = intervals[minLength.peek()][1] - intervals[minLength.peek()][0]+1;

                pos.remove(pos.size()-1);
            }
            query++;
            while(!nearestEndingInterval.isEmpty() && (query == q_len || intervals[nearestEndingInterval.peek()][1] < queries[query])){
                
                int removedInterval = nearestEndingInterval.poll();
                invalidInterval.put(removedInterval, true);
            }
        }
        return lengthOfShortestInterval;
    }
}
