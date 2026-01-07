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
    long maxProduct = 0;
    
    public int maxProduct(TreeNode root) {
        // find total sum
        // subSum * (totalSum - subSum)  --> we need to maximize this

        int totalSum = getTotalSum(root, 0);
        long maxSubtreeSum = getSubtreeSum(root, totalSum);
        return (int) (maxProduct % 1_000_000_007);
    }

    public int getTotalSum(TreeNode node, int sum) {
        if(node == null)
            return 0;
        
        sum = node.val + getTotalSum(node.left, sum) + getTotalSum(node.right, sum);
        return sum;
    }

    public long getSubtreeSum(TreeNode node, int totalSum) {
        long sum = 0;

        if(node == null)
            return 0;

        long left = getSubtreeSum(node.left, totalSum);
        long right = getSubtreeSum(node.right, totalSum);

        sum = node.val + left + right;
        maxProduct = Math.max(maxProduct, sum * (totalSum - sum));
        return sum;
    }
}