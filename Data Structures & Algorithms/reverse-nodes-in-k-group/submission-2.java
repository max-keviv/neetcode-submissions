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
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode curr = head;
        ListNode prev = null;
        while(prev != tail){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            // if(curr == tail) break;
        }
        // System.out.println(head.val + " " + tail.val + " " + prev.val);
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        while(head != null && head.next != null){
            ListNode curr = head;
            for(int i=0;i<k;i++)
            {
                if(curr == null) break;
                curr = curr.next;
            }
            if(curr == null) break;
            ListNode next = curr.next;
            head.next = reverse(head.next,curr);
            while(head.next != null) head = head.next;
            head.next = next;
        }
        return dummy.next;
    }
}
