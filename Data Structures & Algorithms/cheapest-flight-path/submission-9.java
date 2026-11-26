
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
        Queue<int[]> queue = new ArrayDeque<>();
        int distance[] = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        queue.add(new int[]{src,k,0});

        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++)
        {
            int from = flights[i][0], to = flights[i][1], price = flights[i][2];
            graph.get(from).add(new ArrayList<>(Arrays.asList(to,price)));
        }

        while(!queue.isEmpty()){
            int from = queue.peek()[0], remaining = queue.peek()[1], currentCost = queue.peek()[2];
            queue.poll();
        
            if(remaining == -1){
                continue;
            }
            for(List<Integer> edge: graph.get(from)){
                int to = edge.get(0);
                int cost = edge.get(1);
                if(distance[to] > currentCost + cost){
                    distance[to] = currentCost + cost;
                    queue.add(new int[]{to,remaining-1,currentCost+cost});
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}


// public class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[] prices = new int[n];
//         Arrays.fill(prices, Integer.MAX_VALUE);
//         prices[src] = 0;
//         List<int[]>[] adj = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             adj[i] = new ArrayList<>();
//         }
//         for (var flight : flights) {
//             adj[flight[0]].add(new int[] { flight[1], flight[2] });
//         }

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] { 0, src, 0 });

//         while (!q.isEmpty()) {
//             var curr = q.poll();
//             int cst = curr[0], node = curr[1], stops = curr[2];
//             if (stops > k) continue;

//             for (var neighbor : adj[node]) {
//                 int nei = neighbor[0], w = neighbor[1];
//                 int nextCost = cst + w;
//                 if (nextCost < prices[nei]) {
//                     prices[nei] = nextCost;
//                     q.offer(new int[] { nextCost, nei, stops + 1 });
//                 }
//             }
//         }
//         return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
//     }
// }