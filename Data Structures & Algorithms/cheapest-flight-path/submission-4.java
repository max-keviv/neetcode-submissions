
// first appraoch try all dfs path 
// class Solution {
//     int ans = Integer.MAX_VALUE;
//     public void dp(int src, int dst, int cost, int k, List<List<List<Integer>>> graph){
//         if(src == dst) {
//             ans = Math.min(ans,cost);
//             return;
//         }
//         if(k < 0) return; 
//         if(graph.get(src) != null && graph.get(src).size() > 0){
//             List<List<Integer>> iter = new ArrayList<>(graph.get(src));
//             for(List<Integer> edge: iter)
//             {
//                 graph.get(src).remove(edge);
//                 dp(edge.get(0),dst,cost+edge.get(1),k-1,graph);
//                 graph.get(src).add(edge);
//             }

//         }
        
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         List<List<List<Integer>>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++) graph.add(new ArrayList<>());
//         Arrays.sort(flights, (a,b) -> Integer.compare(a[2],b[2]));
//         for(int i=0;i<flights.length;i++)
//         {
//             int from = flights[i][0], to = flights[i][1], price = flights[i][2];
//             graph.get(from).add(new ArrayList<>(Arrays.asList(to,price)));
//         }
//         dp(src,dst,0,k,graph);
//         return ans;
//     }
// }


// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         List<List<List<Integer>>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++) graph.add(new ArrayList<>());
//         Arrays.sort(flights, (a,b) -> Integer.compare(a[2],b[2]));
//         for(int i=0;i<flights.length;i++)
//         {
//             int from = flights[i][0], to = flights[i][1], price = flights[i][2];
//             graph.get(from).add(new ArrayList<>(Arrays.asList(to,price)));
//         }
//         Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
//         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]) == 0 ? Integer.compare(a[1],b[1]) : Integer.compare(a[2],b[2]));
//         minHeap.add(new int[]{src,k,0});
//         while(!minHeap.isEmpty()){
//             int from = minHeap.peek()[0], remaining = minHeap.peek()[1], cost = minHeap.peek()[2];
//             minHeap.poll();
//             // System.out.println(from + " " + remaining + " " + cost);
//             if(from == dst) return cost;
//             if(map.get(from) != null)
//             {
//                 List<Integer> cache = map.get(from);
//                 if(cache.get(0) > remaining) continue;
//             }
//             else{
//                 map.put(from,new ArrayList<Integer>(Arrays.asList(remaining,cost)));
//             }
//             if(remaining == -1) continue;
//             for(List<Integer> edge: graph.get(from)){
//                 minHeap.add(new int[]{edge.get(0),remaining-1,cost+edge.get(1)});
//             }

//         }
//         return -1;
//     }
// }
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            for (int[] neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
    }
}
