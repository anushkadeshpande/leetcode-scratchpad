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
    int maxDepth = Integer.MIN_VALUE;
    TreeNode deepestNode = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findSubtree(root, 0);
        return deepestNode;
    }

    public int findSubtree(TreeNode node, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if(node == null)
            return depth;

        
        int leftSubtree = findSubtree(node.left, depth+1);
        int rightSubtree = findSubtree(node.right, depth+1);

        if(leftSubtree == maxDepth && rightSubtree == maxDepth) {
            deepestNode = node;
        }

        return Math.max(leftSubtree, rightSubtree);
    }
}