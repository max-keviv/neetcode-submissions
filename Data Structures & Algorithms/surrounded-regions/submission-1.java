class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        Stack<Integer> bfs = new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
                if(board[i][0]=='O'){
                    board[i][0]='1';
                    bfs.add(i*m);
                }
                if(board[i][m-1]=='O'){
                    board[i][m-1]='1';
                    bfs.add(i*m+m-1);
                }
        }
        for(int i=0;i<m;i++)
        {
                if(board[0][i]=='O'){
                    board[0][i]='1';
                    bfs.add(i);
                }
                if(board[n-1][i]=='O'){
                    board[n-1][i]='1';
                    bfs.add((n-1)*m+i);
                }
        }
        int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!bfs.isEmpty()){
            int pos = bfs.pop();
            int i = pos/m, j = pos%m;
            for(int k=0;k<4;k++)
            {
                int u = i + direction[k][0];
                int v = j + direction[k][1];
                if((u >= 0 && u < n) && ( v >= 0 && v < m) && board[u][v]=='O'){
                    board[u][v]='1';
                    bfs.push(u*m+v);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j] == 'O') board[i][j]='X';
                else if(board[i][j] == '1') board[i][j]='O';
            }
        }
    }
}

//     [
//     ["O","X","X","O","X"],
//     ["X","O","O","X","O"],
//     ["X","O","X","O","X"],
//     ["O","X","O","O","O"],
//     ["X","X","O","X","O"]
//     ]


// [["O","X","X","O","X"],
// ["X","X","X","X","O"],
// ["X","X","X","X","X"],
// ["O","X","O","O","O"],
// ["X","X","O","X","O"]]

// [["O","X","X","O","X"],
// ["X","X","X","X","O"],
// ["X","X","X","O","X"],
// ["O","X","O","O","O"],
// ["X","X","O","X","O"]]

