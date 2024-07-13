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
    
    public List<Integer> traverse(TreeNode node, List<Integer> res) {
        if(node != null) {
            traverse(node.left, res);
            res.add(node.val);
            traverse(node.right, res);
        }
        
        return res;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        
        return traverse(root, traversal);
    }
}