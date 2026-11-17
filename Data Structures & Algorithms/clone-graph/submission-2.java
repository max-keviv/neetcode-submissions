/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> bfs = new ArrayDeque<Node>();
        Map<Node,Node> nodeMap = new HashMap<Node,Node>();
        bfs.add(node);
        nodeMap.put(node,new Node(node.val));
        while(!bfs.isEmpty()){
            Node cur = bfs.poll();

            for(Node nei: cur.neighbors)
            {
                if(!nodeMap.containsKey(nei)){
                    Node next = new Node(nei.val);
                    nodeMap.put(nei,next);
                    bfs.add(nei);
                }
                nodeMap.get(cur).neighbors.add(nodeMap.get(nei));
            }
        }
        return nodeMap.get(node);
    }
}