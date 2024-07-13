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
    
    public List<Integer> traverse(TreeNode node, List<Integer> traversal) {
        if(node != null) {
            traversal.add(node.val);
            traverse(node.left, traversal);
            traverse(node.right, traversal);
        }
        
        return traversal;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        
        return traverse(root, traversal);
    }
}