class Solution {
    public static class Node {
        boolean isWord = false;
        String word;
        Node[] nextNode = new Node[26];
    }

    public Node root;

    public Set<String> ans;

    public int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};

    public void dfs(int i, int j, char[][] board, boolean[][] visited, Node root){
        if(root == null) return;
        if(root.isWord == true) ans.add(root.word);

        // System.out.print(i+" "+ j + " " + board[i][j]);
        if((i >= board.length || j >= board[0].length) || (i < 0 || j < 0)) return;
        if(visited[i][j] == true) return;
        // System.out.print(i+" "+ j + " " + board[i][j] + " ");
        visited[i][j] = true;
        int c = board[i][j] - 'a';
        for(int p=0;p<moves.length;p++)
        {

            int m = i+moves[p][0], n = j+moves[p][1];
            // System.out.println(m+" "+ n + " " + board[m][n]);
            dfs(m,n,board,visited,root.nextNode[c]);
        }
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        ans = new HashSet<>();
        for(String word: words)
        {
            Node node = root;
            for(int i=0;i<word.length();i++)
            {
                int j = word.charAt(i)-'a';
                if(node.nextNode[j] == null) node.nextNode[j] = new Node();
                node = node.nextNode[j];
            }
            node.word = word;
            node.isWord = true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
        for(int j=0;j<board[0].length;j++){
        dfs(i,j,board,visited,root);
        System.out.println();
        }
        return new ArrayList<>(ans);

    }
}
