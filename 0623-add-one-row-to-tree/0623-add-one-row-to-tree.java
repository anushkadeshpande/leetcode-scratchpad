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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // if depth == 1, create new node and change root to the new node and new node's left = root
        // else, perform dfs
        // at level = depth, add new node and the existing node will be its child
        
        if(depth == 1) {
            TreeNode newRootNode = new TreeNode(val, root, null);
            return newRootNode;
        } else {
            addNode(root, val, depth, 1);
            return root;
        }
    }
    
    
    private void addNode(TreeNode node, int val, int depth, int level) {
        if(node == null)
            return;
        if(level+1 == depth) {
            // add node here
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        } else {
            addNode(node.left, val, depth, level+1);
            addNode(node.right, val, depth, level+1);
        }
    }
}