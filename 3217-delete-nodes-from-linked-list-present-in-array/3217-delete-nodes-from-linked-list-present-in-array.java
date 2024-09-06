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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>();
        
        for(int num: nums)
            numbers.add(num);
        
        ListNode temp = head;
        ListNode previous = null;
        while(temp != null) {
            if(numbers.contains(temp.val)) {
                if(previous != null) {
                    previous.next = temp.next;
                    temp = temp.next;
                }
                else {
                    head = head.next;
                    temp = head;
                }
            } else {
                previous = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}