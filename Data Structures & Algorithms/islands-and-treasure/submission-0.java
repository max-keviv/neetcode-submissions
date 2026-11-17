class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Integer> bfs = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 0){
                    bfs.add(i*m+j);
                }
            }
        }
        int dis = 1;
        int x[] = {1,0,-1,0};
        int y[] = {0,1,0,-1};
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i=0;i<size;i++)
            {
                int cur = bfs.poll();
                int x1 = cur/m;
                int y1 = cur%m;
                for(int move=0;move<4;move++)
                {
                    int u = x1 + x[move];
                    int v = y1 + y[move];
                    if((u>=0&&u<n) && (v>=0&&v<m) && grid[u][v] == Integer.MAX_VALUE){
                        bfs.add(u*m+v);
                        grid[u][v]=dis;
                    }
                }
            }
            dis++;
        }
    }
}
