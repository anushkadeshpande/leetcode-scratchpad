/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let fastPointer = null
    let slowPointer = null
    
    // initialize fast and slow pointers
    slowPointer = head
    fastPointer = head
    for(let i=0; i<n; i++) {
        fastPointer = fastPointer.next
    }
    if(fastPointer !== null) {
        while(fastPointer.next !== null) {
            fastPointer = fastPointer.next
            slowPointer = slowPointer.next
        }
    
        // remove the node next to slow pointer
        slowPointer.next = slowPointer.next.next   
    } else {
        head = head.next
    }
    return head
    
};