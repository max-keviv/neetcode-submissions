class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mxArea = 0;
        int currentArea = 0;
        Stack<Integer> dfs = new Stack<Integer>();
        int x[] = {1,0,-1,0};
        int y[] = {0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                currentArea = 0;
                if(grid[i][j] == 1) {
                    dfs.push(i*m+j);
                    grid[i][j]=0;
                }
                while(!dfs.isEmpty()){
                    int pos = dfs.pop();
                    currentArea++;
                    int x1 = pos/m, y1 = pos%m;
                    // System.out.println("i = "+x1+" j = "+y1);
                    for(int move=0;move<4;move++)
                    {
                        int x2 = x1 + x[move];
                        int y2 = y1 + y[move];
                        if((x2 >= 0 && x2 < n) && (y2 >=0 && y2 < m) && (grid[x2][y2] == 1)){
                            dfs.push(x2*m+y2);
                            grid[x2][y2]=0;
                        }
                    }
                }
                // System.out.println(currentArea);
                mxArea = Math.max(mxArea,currentArea);
            }
        }
        return mxArea;
    }
}
