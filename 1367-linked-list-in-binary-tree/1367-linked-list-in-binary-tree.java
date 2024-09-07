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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean dfs(TreeNode treeNode, ListNode listNode, ListNode head) {
        // we reached the end of linked list and found all elements
        if(listNode == null)
            return true;
        
        // we finished traversing the tree, but didn't find all elements
        if(treeNode == null)
            return false;
        
        if(treeNode.val == listNode.val) 
            listNode = listNode.next;
        else if(treeNode.val == head.val)
            head = head.next;
        else 
            listNode = head;
        
        return dfs(treeNode.left, listNode, head) || dfs(treeNode.right, listNode, head);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        // dfs on the tree
        return dfs(root, head, head);
    }
}