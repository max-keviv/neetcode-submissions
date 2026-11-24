class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean visited[] = new boolean[n+1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            int start = times[i][0];
            int end = times[i][1];
            int time = times[i][2];
            graph.get(start).add(new ArrayList<>(Arrays.asList(end,time)));
        }
        minHeap.add(new int[]{-1,k,0});
        int ans = 0;
        int noOfVisitedNodes = 0;
        while(!minHeap.isEmpty()){
            int node[] = minHeap.poll();
            int start = node[0];
            int end = node[1];
            int time = node[2];
            if(visited[end]) continue;
            ans = Math.max(ans,time);
            // System.out.println(start + " " + end + " " + time);
            noOfVisitedNodes++;
            visited[end]=true;
            List<List<Integer>> edges = graph.get(end);
            for(List<Integer> edge: edges){
                if(!visited[edge.get(0)]){
                    minHeap.add(new int[]{end,edge.get(0),edge.get(1)+time});
                }
            }
        }

        return noOfVisitedNodes == n ? ans : -1;
    }
}
