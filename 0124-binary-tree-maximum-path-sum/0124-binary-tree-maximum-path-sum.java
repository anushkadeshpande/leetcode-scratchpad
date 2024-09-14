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
        findMaxPathSum(root);
        
        return maxPathSum;
    }
    
    public int findMaxPathSum(TreeNode node) {
        if(node == null)
            return 0;
        
        int leftSum = findMaxPathSum(node.left);
        int rightSum = findMaxPathSum(node.right);
        
        // finding the max of the sum of left and right subtrees
        int maxSubtreeSum = Math.max(leftSum, rightSum);
        
        // if both are negative, ignore them and set the maxSum as 0
        if(maxSubtreeSum < 0)
            maxSubtreeSum = 0;
        
        // finding sum of intermediate path
        // we can choose to go via the maxSum path or consider the entire path from left to right
        // with this we also choose whether to even consider going any path or not
        int intermediateMaxPathSum = Math.max(maxSubtreeSum + node.val, node.val + leftSum + rightSum);
        
        // max path sum will be the max of the existing maxPathSum or the intermediate maxPathSum
        maxPathSum = Math.max(maxPathSum, intermediateMaxPathSum);
        
        // for next iteration, consider only the max subtree
        return maxSubtreeSum + node.val;

    }
}