/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // traverse list1
        // put the nodes in a set
        ListNode temp = headA;
        Set<ListNode> nodeSet = new LinkedHashSet<>();
        
        while(temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        
        temp = headB;
        while(temp != null) {
            if(nodeSet.contains(temp)) {
                return temp;
            }
            
            temp = temp.next;
        }
        
        return null;
    } 
}