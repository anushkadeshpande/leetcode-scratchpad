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
    Map<Integer, Integer> nodes = new HashMap<>();
    
    public TreeNode constructTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        
        // base condition
        if(inorderStart > inorderEnd || postorderStart > postorderEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder[postorderEnd]);
        
        int currentPos = nodes.get(postorder[postorderEnd]);
        
        node.left = constructTree(inorder, inorderStart, currentPos - 1, postorder, postorderStart, postorderStart + currentPos - inorderStart - 1);
        
        node.right = constructTree(inorder, currentPos + 1, inorderEnd, postorder, postorderStart + currentPos - inorderStart, postorderEnd-1);
        
        return node;
        
    }
     
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // put inorder traversal in map for easy access
        for(int i=0; i<inorder.length; i++)
            nodes.put(inorder[i], i);
        
        // the last element of postorder will be the root node
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        
        return constructTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length - 1);
    }
}