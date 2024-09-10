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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        
        while(temp!=null) {
            int num = temp.val;
            if(temp.next == null)
                break;
            int gcd = getGCD(num, temp.next.val);
            
            ListNode newNode = new ListNode(gcd, temp.next);
            temp.next = newNode;
                        
            
            
            temp = temp.next.next;

            
        }
        
        return head;
    }
    
    public int getGCD(int a, int b) {
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        
        return result;
    }
}