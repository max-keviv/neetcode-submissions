/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node,Node> nodeMap = new HashMap<>();
        Node newHead = new Node(head.val);

        nodeMap.put(head,newHead);

        Node newNextNode = newHead;
        Node nextNode = head.next;
        while(nextNode != null){
            newNextNode.next = new Node(nextNode.val);
            newNextNode = newNextNode.next;
            nodeMap.put(nextNode,newNextNode);
            nextNode = nextNode.next;
        }
        Node ptr = head;
        Node newPtr = newHead;
        while(ptr != null)
        {
            newPtr.random = nodeMap.get(ptr.random);
            ptr = ptr.next;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}
