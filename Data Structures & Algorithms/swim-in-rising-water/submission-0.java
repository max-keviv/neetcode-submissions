class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        boolean visited[][] = new boolean[n][m];
        minHeap.add(new int[]{0,grid[0][0]});
        int moves[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int ans = 0;
        while(!minHeap.isEmpty()){
            int p = minHeap.peek()[0], time = minHeap.peek()[1];
            int i = p/m, j = p%m;
            minHeap.poll();
            if(visited[i][j]) continue;
            // System.out.println("i = "+i+" j = "+j);
            ans = Math.max(ans,time);
            visited[i][j]=true;
            if(i == n-1 && j== m-1) return ans;
            for(int k=0;k<4;k++)
            {
                int xi = i+moves[k][0], xj = j+moves[k][1];
                if((xi >= 0 && xi < n) && (xj >= 0 && xj < m) && visited[xi][xj] == false)
                {
                    minHeap.add(new int[]{xi*m+xj,Math.max(time,grid[xi][xj])});
                }
            }
        }
        return ans;
    }
}
