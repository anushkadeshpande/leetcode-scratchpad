/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // take level order traversal
        // if node is null, add a #
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        String serializedTree = "";
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(node == null)
                serializedTree += "#,";
            
            else
                serializedTree += node.val + ",";
            
            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        System.out.println(serializedTree);
        return serializedTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        if(!parts[0].equals("#")) {
            
        root = new TreeNode(Integer.valueOf(parts[0]));
        
        queue.add(root);

        for(int i=1; i<parts.length; i++) {
            TreeNode node = queue.poll();
            
            if(!parts[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(parts[i]));
                node.left = leftNode;
                queue.add(leftNode);
            }
            
            i++;
            
            if(!parts[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(parts[i]));
                node.right = rightNode;
                queue.add(rightNode);
            }
        }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));