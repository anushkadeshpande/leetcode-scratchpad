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
    int answer = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        // dfs
        // if node.val is even
        // check its grandchild and add it
        if(root != null) {
            if(root.val % 2 == 0) {
                if(root.left != null) {
                    if(root.left.left != null)
                        answer += root.left.left.val;
                    
                    if(root.left.right != null)
                        answer += root.left.right.val;
                }
                
                if(root.right != null) {
                    if(root.right.left != null)
                        answer += root.right.left.val;
                    
                    if(root.right.right != null)
                        answer += root.right.right.val;
                }
            }
            
            sumEvenGrandparent(root.left);
            sumEvenGrandparent(root.right);
        }
        
        return answer;
    }
}