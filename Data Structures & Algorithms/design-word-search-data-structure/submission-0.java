class WordDictionary {

    public static class Node {
        boolean word;
        Map<Character,Node> nextNode = new HashMap<>();
    }

    public final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            Character c = word.charAt(i);
            if(node.nextNode.get(c) == null) node.nextNode.put(c, new Node());
            node = node.nextNode.get(c);
        }
        node.word=true;
    }

    public boolean search(String word) {
        // Node node = root;
        Queue<Pair<Integer,Node>> dfs = new ArrayDeque<>();
        dfs.add(new Pair(0,root));
        while(!dfs.isEmpty()){
            Pair<Integer,Node> p = dfs.poll();
            int key = p.getKey();
            Node node = p.getValue();
            if( key >= word.length()) 
            {
                if(node != null && node.word == true) return true;
            }
            else if(word.charAt(key) == '.') {
                for(Node nextNode: node.nextNode.values()){
                    dfs.add(new Pair(key+1,nextNode));
                }
            }
            else{
                if(node.nextNode.get(word.charAt(key)) != null)
                    dfs.add(new Pair(key+1,node.nextNode.get(word.charAt(key))));
            }
        }
        return false;
    }
}
