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
    
    Integer prevVal;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        
        // find inorder traversal and make sure it is sorted
        if(root != null) {
            isValidBST(root.left);
            
            if(null == prevVal) {
                prevVal = root.val;
            } else {
                if(prevVal >= root.val)
                    flag = false;
                prevVal = root.val;
            }
            isValidBST(root.right);
            return flag;
        }
        return false;
    }
}