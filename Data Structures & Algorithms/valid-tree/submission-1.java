class Solution {
    public boolean dfs(int u, int prev, boolean[] visited, List<List<Integer>> graph){
        visited[u] = true;
        for(int adjNodes: graph.get(u)){
            if(adjNodes != prev && visited[adjNodes] == true ) return false;
            if(adjNodes != prev && !dfs(adjNodes,u,visited,graph)) return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if(!dfs(0,-1,visited,graph)) return false;
        for(int i=0;i<n;i++)
        if(visited[i]==false) return false;
        return true;
    }
    // public boolean dsu(){

    // }
}
