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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // find length of ll
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        
        int parts = size / k;
        int remainder = size % k;
        
        System.out.println(size);
        
        temp = head;
        ListNode[] listParts = new ListNode[k];
        int j = 0;
        while(temp != null) {
            listParts[j] = temp;
            int partLength = parts;
            
            if(remainder > 0) {
                partLength++;
                remainder--;
            }
            
            for(int i=0; i<partLength - 1; i++) {
                temp = temp.next;
            }
            
            if(temp != null && partLength > 0) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
            
            j++;
        }
        
        return listParts;
    }
}