/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */

let inorderTraversalRecordLeafNodes = (node, leafNodes = []) => {
    if(node == null)
        return
    // leaf node
    if(node.left == null && node.right == null)
        leafNodes.push(node.val)
    
    inorderTraversalRecordLeafNodes(node.left, leafNodes)
    inorderTraversalRecordLeafNodes(node.right, leafNodes)
    
    return leafNodes
}

var leafSimilar = function(root1, root2) {
    // inorder traversal of both trees
    // if both children are null, then record leaf node in array
    // compare leaf node arrays for both trees
    
    let treeOneLeafNodes = inorderTraversalRecordLeafNodes(root1)
    let treeTwoLeafNodes = inorderTraversalRecordLeafNodes(root2)
    
    if(treeOneLeafNodes.length !== treeTwoLeafNodes.length)
        return false
    else if(treeOneLeafNodes.every((value, index) => value === treeTwoLeafNodes[index]))
        return true
    return false
};