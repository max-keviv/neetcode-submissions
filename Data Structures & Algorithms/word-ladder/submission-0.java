class Solution {
    public boolean exactlyOnePositionDiff(String a, String b){
        int n = a.length();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            if(a.charAt(i) == b.charAt(i)) count++;
        }
        return (count == n - 1);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> bfs = new ArrayDeque<String>();
        int n = wordList.size();
        bfs.add(beginWord);
        int steps = 1;
        boolean visited[] = new boolean[n];

        
        if(!wordList.contains(endWord)) return 0;
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i=0;i<size;i++)
            {
                String currWord = bfs.poll();
                System.out.print(currWord);
                for(int j=0;j<n;j++)
                {
                    if(exactlyOnePositionDiff(currWord,wordList.get(j)) && visited[j] != true){
                        if(wordList.get(j).matches(endWord)) return steps+1;
                        visited[j] = true;
                        bfs.add(wordList.get(j));
                    }
                }
            }
            System.out.println();
            steps++;
        }
        return 0;
    }
}
