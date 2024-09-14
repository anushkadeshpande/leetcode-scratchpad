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
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxHeight(root);
        
        return maxPathSum;
    }
    
    public int findMaxHeight(TreeNode node) {
        if(node == null)
            return 0;
        
        int leftSum = findMaxHeight(node.left);
        int rightSum = findMaxHeight(node.right);
        
        int maxSum = Math.max(leftSum, rightSum);
        
        if(maxSum < 0)
            maxSum = 0;
        
        int ans = Math.max(maxSum + node.val, node.val + leftSum + rightSum);
        
        maxPathSum = Math.max(ans, maxPathSum);
        
        return maxSum + node.val;

    }
}