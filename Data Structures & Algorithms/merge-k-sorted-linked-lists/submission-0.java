/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;
        
        // keep a pointer of iterator at each list item
        // keep iterator this pointer and in each iteration select the smallest one
        Comparator<ListNode> c = (a,b) -> a.val - b.val;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(c);
        
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
            pq.add(lists[i]);
        }

        while(pq.size() > 0){
           ListNode node = pq.poll();
           if(node.next != null)
                pq.add(node.next);
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }
}
