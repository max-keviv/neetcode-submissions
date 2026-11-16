

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            boolean[] visited = new boolean[n + 1];
            
            // Check if u can already reach v before adding the edge
            if (!adj.get(u).isEmpty() && !adj.get(v).isEmpty() && canReach(adj, visited, u, v)) {
                return edge;
            }
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{0, 0};
    }

    private boolean canReach(List<List<Integer>> adj, boolean[] visited, int curr, int target) {
        if (curr == target) return true;
        visited[curr] = true;
        for (int next : adj.get(curr)) {
            if (!visited[next] && canReach(adj, visited, next, target)) {
                return true;
            }
        }
        return false;
    }
}
