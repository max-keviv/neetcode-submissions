class PrefixTree {

    class Node {
        Boolean terminal;
        Node[] nextChar; 
        public Node(){
            this.terminal = false;
            this.nextChar = new Node[26];
        }
        public void addNextChar(Character c){
            int pos = c-'a';
            if((pos >= 0 && pos < 26) && nextChar[pos] == null)
            {
                nextChar[pos] = new Node();
            }
        }
        public Node nextNode(Character t){
            int pos = t-'a';
            if(pos >= 0 && pos < 26)
            {
                return nextChar[pos];
            }
            return null;
        }
        public void makeTerminal(){
            this.terminal = true;
        }
        public Boolean isTerminal(){
            return this.terminal;
        }
    }
    Node start;
    public PrefixTree() {
        this.start = new Node();
    }

    public void insert(String word) {
        Node curr = start;
        for(int i=0;i<word.length();i++){
            curr.addNextChar(word.charAt(i));
            curr = curr.nextNode(word.charAt(i));
        }
        curr.makeTerminal();
    }

    public boolean search(String word) {
        Node curr = start;
        int i=0;
        while(curr != null && i<word.length()){
            curr = curr.nextNode(word.charAt(i));
            i++;
        }
        if(curr == null) return false;
        return curr.isTerminal();
    }

    public boolean startsWith(String prefix) {
        Node curr = start;
        int i=0;
        while(curr != null && i<prefix.length()){
            curr = curr.nextNode(prefix.charAt(i));
            i++;
        }
        if(curr == null) return false;
        return true;
    }
}
