class Solution {

    int rank[];
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++)
        parent[i]=i;
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];
            if(!union(u,v)){
                return edge;
            }
        }
        return new int[]{0,0};
    }
    public boolean union(int u, int v)
    {
        int parentU = find(u);
        int parentV = find(v);
        int rankU = rank[parentU];
        int rankV = rank[parentV];
        if(parentU == parentV){
            return false;
        }
        else if(rankU > rankV){
            parent[parentV] = parentU;
        }
        else if(rankU < rankV){
            parent[parentU] = parentV;
        }
        else{
            parent[parentV] = parentU;
            rank[parentU]++;
        }
        return true;
    }
    public int find(int u)
    {
        if(parent[u] != u) return find(parent[u]);
        return u;
    } 
}
