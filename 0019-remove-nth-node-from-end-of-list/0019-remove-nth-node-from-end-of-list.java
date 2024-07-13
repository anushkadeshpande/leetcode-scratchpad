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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        for(int i=0; i<n; i++) {
            if(fast != null)
                fast = fast.next;
        }
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(prev != null)
            prev.next = slow.next;
        else {
            // prev = slow.next;
            // if prev is null, slow has to be at the 1st pos
            head = head.next;
        }
        return head;
    }
}