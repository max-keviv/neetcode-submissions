class Solution {

    int rank[];
    int parent[];
    public boolean dfs(int u, int prev, boolean[] visited, List<List<Integer>> graph){
        visited[u] = true;
        for(int adjNodes: graph.get(u)){
            if(adjNodes != prev && visited[adjNodes] == true ) return false;
            if(adjNodes != prev && !dfs(adjNodes,u,visited,graph)) return false;
        }
        return true;
    }
    public boolean validTreeDFS(int n, int[][] edges){
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
    public boolean validTree(int n, int[][] edges) {
        // validTreeDFS(n,edges);
        return validTreeDSU(n,edges);
    }
    public boolean validTreeDSU(int n, int[][] edges){
        
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            if(!union(edges[i][0],edges[i][1])) return false;
        }
        int flag = 0;
        for(int i=0;i<n;i++)
        if( parent[i] == i ) flag++;

        if(flag > 1) return false;
        return true;
    }
    public boolean union(int u, int v)
    {
        int parentX = find(u);
        int parentY = find(v);
        int rankX = rank[parentX];
        int rankY = rank[parentY];

        if(parentX == parentY) return false;
        if(rankX > rankY) {
            parent[parentY] = parentX;
        }
        else if(rankY > rankX)
        {
            parent[parentX] = parentY;
        }
        else {
            rank[parentX]++;
            parent[parentY]=parentX;
        }
        return true;
    }
    public int find(int u)
    {
        if(parent[u] == u) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }
    
}
