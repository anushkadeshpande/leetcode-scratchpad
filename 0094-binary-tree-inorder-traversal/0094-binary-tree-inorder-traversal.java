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
    
//     public List<Integer> traverse(TreeNode node, List<Integer> res) {
//         if(node != null) {
//             traverse(node.left, res);
//             res.add(node.val);
//             traverse(node.right, res);
//         }
        
//         return res;
//     }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        
        // stack.push(root);
        // TreeNode temp;
        while(true) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                if(stack.isEmpty())
                    break;
                root = stack.pop();
                traversal.add(root.val);
                root = root.right;
            
            }
        }
        
        // return traverse(root, traversal);
        return traversal;
    }
}