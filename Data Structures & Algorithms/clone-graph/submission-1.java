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
        Map<Node,Node> nodeMap = new HashMap<Node,Node>();
        return dfs(node,nodeMap);
    }
    public Node dfs(Node node, Map<Node,Node> nodeMap){
        if(node == null) return null;
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        Node newNode = new Node(node.val);
        nodeMap.put(node,newNode);
        for(Node nei: node.neighbors){
            newNode.neighbors.add(dfs(nei,nodeMap));
        }
        return newNode;
    }
}