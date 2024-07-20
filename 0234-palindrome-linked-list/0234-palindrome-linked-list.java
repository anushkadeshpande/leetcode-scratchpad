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
    public boolean isPalindrome(ListNode head) {
        // go to the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode temp = null;
        
        while(fast != null && fast.next != null) {
            // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the 2nd half of the list
        // i.e the one that starts from slow
        // bring fast to the beginning
        prev = slow;
        slow = slow.next;
        prev.next = null;
        
        while(slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            
            slow = temp;
        }
        
        fast = head;
        slow = prev;
        
        while(slow != null) {
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
}