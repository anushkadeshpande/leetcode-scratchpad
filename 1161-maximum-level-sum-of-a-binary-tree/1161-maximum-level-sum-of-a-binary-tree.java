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
    Map<Integer, Integer> sum = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        // level order traversal
        // dfs
        dfs(root, 1);
        return getMaxLevelSum();
    }

    public void dfs(TreeNode node, int level) {
        if(node == null)
            return;
        if(!sum.containsKey(level))
            sum.put(level, node.val);
        else
            sum.put(level, sum.get(level) + node.val);
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }

    public int getMaxLevelSum() {
        int maxSum = Integer.MIN_VALUE;
        int maxlevel = 0;

        for(int s: sum.keySet()) {
            if(sum.get(s) > maxSum) {
                maxSum = sum.get(s);
                maxlevel = s;
            }
        }

        return maxlevel;
    }
}