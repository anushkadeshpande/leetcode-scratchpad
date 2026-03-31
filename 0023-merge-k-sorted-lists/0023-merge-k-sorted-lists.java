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
    public ListNode mergeKLists(ListNode[] lists) {
        // initially lists[i] would be pointing to the 1st node of ith list
        ListNode result = new ListNode();

        // construct a priority queue of all list heads
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l: lists) {
            if(l != null)
                minHeap.add(l);
        }

        ListNode temp = result;
        // while heap is not null, fetch the least element in the heap
        // for that element, move to the next node if it is not null
        // heapify
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            temp.next = new ListNode(node.val);
            temp = temp.next;

            if(node.next != null)
                minHeap.add(node.next);
        }

        return result.next;
    }
}