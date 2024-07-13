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
    
    public List<Integer> traversal(TreeNode node, List<Integer> traversal) {
        if(node != null) {
            traversal(node.left, traversal);
            traversal(node.right, traversal);
            traversal.add(node.val);
        }
        
        return traversal;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        
        return traversal(root, traversal);
    }
}