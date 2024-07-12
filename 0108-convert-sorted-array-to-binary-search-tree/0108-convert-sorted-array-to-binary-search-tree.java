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
    
    public TreeNode constructTree(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        // construct a new TreeNode
        TreeNode root = new TreeNode(nums[mid]);
        if(start < mid)
            root.left = constructTree(nums, start, mid-1);
        if(end > mid)
            root.right = constructTree(nums, mid+1, end);
        
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        // find mid, that'll be the root
        // call the same function for left and right subarrays
        return constructTree(nums, 0, nums.length - 1);
        
    }
}