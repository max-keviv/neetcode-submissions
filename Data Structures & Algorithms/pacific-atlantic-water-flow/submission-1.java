class Solution {
    int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int i,int j, int n, int m, int[][] heights, boolean[][] visited)
    {
        visited[i][j] = true;
        for(int k=0;k<4;k++)
        {
            int u = i + direction[k][0];
            int v = j + direction[k][1];
            if(( u >= 0 && u < n ) && (v >= 0 && v < m) && heights[i][j] <= heights[u][v] && !visited[u][v]){
                dfs(u,v,n,m,heights,visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];


        for(int j=0;j<m;j++)
        {
            if(!pacific[0][j]){
                dfs(0,j,n,m,heights,pacific);
            }
        }
        for(int i=1;i<n;i++)
        {
            if(!pacific[i][0]){
                dfs(i,0,n,m,heights,pacific);
            }
        }
        
        
        for(int j=0;j<m;j++)
        {
            if(!atlantic[n-1][j]){
                dfs(n-1,j,n,m,heights,atlantic);
            }
        }
        for(int i=0;i<n-1;i++)
        {
            if(!atlantic[i][m-1]){
                dfs(i,m-1,n,m,heights,atlantic);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j]&&atlantic[i][j]) ans.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return ans;
    }
}
