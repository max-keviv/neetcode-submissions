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
        Map<Node,Node> nodeMap = new HashMap<>();
        Node newNode = new Node(node.val);
        newNode.neighbors = node.neighbors;
        bfs.add(node);
        nodeMap.put(node,newNode);
        // Map<Node,boolean> visited = new HashMap<>():
        while(!bfs.isEmpty()){
            Node curr_node = bfs.poll();
            List<Node> adjNode = new ArrayList<Node>();
            for(Node next:curr_node.neighbors){

                if(nodeMap.get(next) != null){
                    Node existingNode = nodeMap.get(next);
                    adjNode.add(existingNode);
                    // if(visited[existingNode]!=true){
                    // bfs.push(existingNode);
                    // visited[existingNode]=true;
                    // }
                }
                else{
                    Node newNextNode = new Node(next.val);
                    newNextNode.neighbors = next.neighbors;
                    adjNode.add(newNextNode);
                    nodeMap.put(next,newNextNode);
                    bfs.add(newNextNode);
                }
            }
            curr_node.neighbors = adjNode;
        }
        return newNode;
    }
}