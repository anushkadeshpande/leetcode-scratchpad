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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode result = null;
        ListNode temp = null;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;            
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            
            ListNode digitNode = new ListNode(sum % 10);
            if(result == null) {
                result = digitNode;
                temp = result;
            }
            else {
                temp.next = digitNode;
                temp = digitNode;
            }            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if (carry > 0) {
    temp.next = new ListNode(carry);
}
        return result;
    }
}