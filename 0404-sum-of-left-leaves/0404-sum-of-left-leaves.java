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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        
        if(null != root) {
            if(null != root.left) {
                if(null == root.left.left && null == root.left.right)
                    sum += root.left.val;
                
                else
                    sum += sumOfLeftLeaves(root.left);
            }
            
            if(null != root.right)
                sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}