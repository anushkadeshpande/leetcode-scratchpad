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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        
        if(root != null) {
           calculate(root, 0); 
        }
        
        return sum;
    }
    
    private void calculate(TreeNode node, int n) {
        if(node == null)
            return;
        
        // number till now
        n = (n * 10) + node.val;
        
        if(node.left == null && node.right == null) {
            sum += n;
        }
        
        calculate(node.left, n);
        calculate(node.right, n);
    }
}