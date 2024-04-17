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
    StringBuilder minString = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        // dfs
        dfs(root, new StringBuilder());
        
        return minString.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder s) {
        if(node == null)
            return;
        
        s.append((char)('a'+ node.val));
        if(node.left == null && node.right == null) {
            // compare
            StringBuilder reversed = new StringBuilder(s).reverse();
            if(minString.length() == 0 || reversed.toString().compareTo(minString.toString()) < 0) {
                minString.setLength(0);
                minString.append(reversed);
            }
          
            // s.reverse();
        }
        
        dfs(node.left, s);
        dfs(node.right, s);
        
        s.setLength(s.length() - 1);
    }
    
}