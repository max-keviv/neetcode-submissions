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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rev = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(rev != null){
            ListNode next = rev.next;
            rev.next = prev;
            prev = rev;
            rev = next;
        }
        ListNode secondNode = prev;
        ListNode firstNode = head;
        while(firstNode != null && secondNode != null)
        {
            ListNode firstNext = firstNode.next;
            firstNode.next = secondNode;
            ListNode secondNext = secondNode.next;
            secondNode.next = firstNext;
            firstNode = firstNext;
            secondNode = secondNext;
        }
    }
}
