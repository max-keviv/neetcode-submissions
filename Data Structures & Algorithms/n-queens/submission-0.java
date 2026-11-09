class Solution {
    public void placeQ(int i, int j, int n, List<List<Integer>> intersections, List<String> board)
    {
        for(int l=0;l<n;l++)
        {
            intersections.get(l).set(j,intersections.get(l).get(j) + 1);
            intersections.get(i).set(l,intersections.get(i).get(l) + 1);
        }

        int p=i,q=j;
        while(p>=0&&q>=0)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) + 1);
            p--;
            q--;
        }
        p=i+1;
        q=j+1;
        while(p<n&&q<n)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) + 1);
            p++;
            q++;
        }
        p=i+1;
        q=j-1;
        while(p<n&&q>=0)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) + 1);
            p++;
            q--;
        }
        p=i-1;
        q=j+1;
        while(p>=0&&q<n)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) + 1);
            p--;
            q++;
        }
        
        StringBuilder sb = new StringBuilder(board.get(i));
        sb.setCharAt(j,'Q');
        board.set(i,sb.toString());
    }
    public void unPlaceQ(int i, int j, int n, List<List<Integer>> intersections, List<String> board){

        for(int l=0;l<n;l++)
        {
            intersections.get(l).set(j,intersections.get(l).get(j) - 1);
            intersections.get(i).set(l,intersections.get(i).get(l) - 1);
        }
        int p=i,q=j;
        while(p>=0&&q>=0)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) - 1);
            p--;
            q--;
        }
        p=i+1;
        q=j+1;
        while(p<n&&q<n)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) - 1);
            p++;
            q++;
        }
        p=i+1;
        q=j-1;
        while(p<n&&q>=0)
        {
            intersections.get(p).set(q,intersections.get(p).get(q) - 1);
            p++;
            q--;
        }
        p=i-1;
        q=j+1;
        while(p>=0&&q<n)
        {
            intersections.get(p).set(q, intersections.get(p).get(q) - 1);
            p--;
            q++;
        }
        StringBuilder sb = new StringBuilder(board.get(i));
        sb.setCharAt(j,'.');
        board.set(i,sb.toString());
    }
    public void nQueens(int n, int placedQueens, List<String> board, List<List<Integer>> intersections, List<List<String>> ans){
        if(placedQueens == n)
        {
            ans.add(new ArrayList<>(board));
            return;
        }
        int i=placedQueens;
        {
            for(int j=0;j<n;j++)
            {
                if(intersections.get(i).get(j) == 0){
                    placeQ(i,j,n,intersections,board);
                    nQueens(n,placedQueens+1,board,intersections,ans);
                    unPlaceQ(i,j,n,intersections,board);
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        List<List<Integer>> intersections = new ArrayList<>(n);
        for(int i=0;i<n;i++)
        {
            board.add(".".repeat(n));
            intersections.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }
        nQueens(n,0,board,intersections,ans);
        return ans;
    }
}
