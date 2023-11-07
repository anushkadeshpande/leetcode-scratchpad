/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    let leftDepth = 0
    let rightDepth = 0
    console.log(root)
    if(root != null) { 
    if(root.left != null)
        leftDepth = maxDepth(root.left)
    
    if(root.right != null)
        rightDepth = maxDepth(root.right)
    return 1 + Math.max(leftDepth, rightDepth)    
}
    return 0

};