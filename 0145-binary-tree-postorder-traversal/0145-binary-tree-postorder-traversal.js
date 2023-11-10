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
 * @return {number[]}
 */
let traverse = (node, traversal) => {
    if(node === null)
        return
    traverse(node.left, traversal)
    traverse(node.right, traversal)
    traversal.push(node.val)
}


var postorderTraversal = function(root) {
    let postorderTraversal = []
    traverse(root, postorderTraversal)
    
    return postorderTraversal
    
};

