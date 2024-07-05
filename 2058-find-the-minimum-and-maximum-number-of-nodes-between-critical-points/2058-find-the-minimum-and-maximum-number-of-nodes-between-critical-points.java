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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        
        if(prev == null)
            return new int[]{-1,-1};
        
        ListNode curr = head.next;
        
        if(curr == null)
            return new int[]{-1,-1};
        
        ListNode next = head.next.next;
        
        if(next == null)
            return new int[]{-1,-1};
        
        List<Integer> criticalPoints = new ArrayList<>();
        int idx = 1;
        while(next != null) {
            
            // current node is the local maxima / local minima
            if((curr.val < prev.val && curr.val < next.val) || (curr.val > prev.val && curr.val > next.val))
                criticalPoints.add(idx);
            
            prev = prev.next;
            curr = curr.next;
            next = next.next;
            
            idx++;
        }
        
        int minDiff = -1;
        int maxDiff = -1;
        
        if(criticalPoints.size() >= 2) {
            Collections.sort(criticalPoints);
            
            for(int i=1; i<criticalPoints.size(); i++)
                minDiff = minDiff != -1? Math.min(minDiff, criticalPoints.get(i) - criticalPoints.get(i-1)) : criticalPoints.get(i) - criticalPoints.get(i-1);
        
            
            maxDiff = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        }
        
        
        return new int[]{minDiff, maxDiff};
    }
}