class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,word,i,j,0)) {
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int pos)
    {
        if(pos == word.length()) return true;

        if(((board.length <= i || board[0].length <= j) || (i < 0 || j < 0 ))) return false;
        if(word.charAt(pos) != board[i][j]) return false;
        // System.out.println(i+" "+j+" "+word.charAt(pos));
        int[] x = {1,0,-1,0};
        int[] y = {0,-1,0,1};
        for(int l=0;l<4;l++)
        {
            int p = i + x[l], q = j + y[l];
            char c = board[i][j];
            board[i][j] = '#';
            if(dfs(board,word,p,q,pos+1)){ 
                board[i][j] = c;
                return true;
            }
            board[i][j] = c;
        }
        return false;
    }
}
