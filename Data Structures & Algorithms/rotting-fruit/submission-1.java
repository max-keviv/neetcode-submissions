class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> bfs = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        int flag = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2) {
                    bfs.add(i*m+j);
                    flag++;
                }
                else if(grid[i][j] == 1) flag++;
            }
        }
        if(flag == 0) return 0;
        int x[] = {1,0,-1,0};
        int y[] = {0,-1,0,1};
        int counter = -1;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0)
            {
                int pos = bfs.poll();
                flag--;
                int i1 = pos/m;
                int j1 = pos%m;
                for(int p=0;p<4;p++)
                {
                    int i2 = i1+x[p];
                    int j2 = j1+y[p];
                    if((i2>=0 && i2 < n) && (j2 >= 0 && j2 < m) && grid[i2][j2] == 1){
                        bfs.add(i2*m+j2);
                        grid[i2][j2]=2;
                    }
                }
            }
            counter++;
        }
        if(flag == 0) return counter;
        return -1;
    }
}
