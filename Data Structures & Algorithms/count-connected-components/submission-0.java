class DSU {
    int[] Parent,Size;
    int comps;
    public DSU(int n){
        comps = n;
        Parent = new int[n+1];
        Size = new int[n+1];
        for(int i=0;i<=n;i++){
            Parent[i]=i;
            Size[i]=i;
        }
    }
    public int find(int u)
    {
        if(Parent[u] == u) return u;
        Parent[u] = find(Parent[u]);
        return Parent[u];
    }
    public boolean union(int u, int v){
        int parentU = find(u);
        int parentV = find(v);
        if(parentU == parentV) return false;
        int sizeU = Size[parentU];
        int sizeV = Size[parentV];
        if(sizeU < sizeV) {
            int tmp = parentU;
            parentU = parentV;
            parentV = tmp;
        }
        comps--;
        Parent[parentV] = parentU;
        Size[parentU] += Size[parentV];
        return true;
    }
}
class Solution {

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge:edges){
            dsu.union(edge[0],edge[1]);
        }
        return dsu.comps;
    }
}
