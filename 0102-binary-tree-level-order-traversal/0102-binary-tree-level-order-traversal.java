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
    List<List<Integer>> solution = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {            
       
        if(root != null) {
             queue.add(root);
            while(!queue.isEmpty()) {
                int queueLength = queue.size();
                
                List<Integer> level = new ArrayList<>();
            
                for(int i=0; i<queueLength; i++) {
                    TreeNode node = queue.remove();
                
                    level.add(node.val);
                    if(node.left != null)
                        queue.add(node.left);
            
                    if(node.right != null)
                        queue.add(node.right);
                }
                    
                solution.add(level);
            }
        }
        
        return solution;
    }
}