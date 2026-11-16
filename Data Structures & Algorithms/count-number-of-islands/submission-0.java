class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int counter = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1')
                {
                    counter++;
                    Stack<Integer> dfs = new Stack<>();
                    dfs.push(i*m+j);
                    grid[i][j] = '0';
                    while(!dfs.isEmpty()){
                        int p = dfs.pop();
                        int u = p/m;
                        int v = p%m;
                        int x[] = {1,0,-1,0};
                        int y[] = {0,-1,0,1};
                        for(int q=0;q<4;q++)
                        {
                            int x1 = u + x[q];
                            int y1 = v + y[q];
                            if((x1>=0 && x1<n) && (y1>=0 && y1<m) && grid[x1][y1] == '1')
                            {
                                dfs.push(x1*m+y1);
                                grid[x1][y1]='0';
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
}
