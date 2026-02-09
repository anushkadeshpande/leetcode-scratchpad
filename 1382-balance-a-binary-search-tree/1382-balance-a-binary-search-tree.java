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
    public TreeNode balanceBST(TreeNode root) {
        // take the inorder traversal -- gives sorted array
        // middle element is the root
        // construct tree acc

        List<Integer> elements = new ArrayList<>();

        getInorderTraversal(root, elements);

        int n = elements.size();

        return constructTree(elements, 0, n-1);
    }

    public void getInorderTraversal(TreeNode root, List<Integer> elements) {
        if(root == null)
            return ;
        getInorderTraversal(root.left, elements);
        elements.add(root.val);
        getInorderTraversal(root.right, elements);
    }


    public TreeNode constructTree(List<Integer> elements, int start, int end) {
        if(start > end)
            return null;

        // take mid node
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(elements.get(mid), null, null);
        node.left = constructTree(elements, start, mid-1);
        node.right = constructTree(elements, mid + 1, end);

        return node;
    }
}