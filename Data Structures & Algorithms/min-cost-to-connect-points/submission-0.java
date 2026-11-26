class Solution {
    class DSU {
        int Parent[];
        int Size[];

        public int find(int x){
            if(Parent[x] == x) return x;
            Parent[x] = find(Parent[x]);
            return Parent[x];
        }
        public boolean union(int u, int v)
        {
            int parentU = find(u);
            int parentV = find(v);

            if(parentU == parentV) return false;

            int sizeU = Size[parentU];
            int sizeV = Size[parentV];

            if(sizeU < sizeV){
                int tmp = parentU;
                parentU = parentV;
                parentV = tmp;
            }

            Parent[parentV] = parentU;
            Size[parentV] += Size[parentU];
            return true;
        }

        public DSU(int n){
            Parent = new int[n+1];
            Size = new int[n+1];
            for(int i=0;i<n;i++){
                Parent[i] = i;
            }
        }

    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++) {
                int bi = points[j][0], bj = points[j][1];
                int ai = points[i][0], aj = points[i][1];
                int dis = Math.abs(bi-ai) + Math.abs(bj-aj);
                minHeap.add(new int[]{i,j,dis});
            }
        }
        int edges = 0, n = points.length, ans = 0;
        DSU dsu = new DSU(n+1);
        while(edges < n - 1 && !minHeap.isEmpty()){
            int i = minHeap.peek()[0], j = minHeap.peek()[1], dis = minHeap.peek()[2];
            if(dsu.union(i,j)){
                edges++;
                ans += dis;
            }
            minHeap.poll();
        }
        return ans;
    }
}
