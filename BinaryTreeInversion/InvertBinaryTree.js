/**
 * Definition for a binary tree node. */
function TreeNode(val, left, right) {
      this.val = (val===undefined ? 0 : val)
      this.left = (left===undefined ? null : left)
      this.right = (right===undefined ? null : right)
}
 
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    if(!root)
        return null
    else { 

    [ root.left, root.right ] = [ root.right, root.left ]
    invertTree(root.left)
    invertTree(root.right)
    return root
    }
};

function arrayToBinaryTree(nums) {
    if (!nums.length) {
      return null;
    }
  
    const mid = Math.floor(nums.length / 2);
  
    const node = new TreeNode(nums[mid]);
  
    node.left = arrayToBinaryTree(nums.slice(0, mid));
    node.right = arrayToBinaryTree(nums.slice(mid + 1));
  
    return node;
  }


var tree = arrayToBinaryTree([4,2,7,1,3,6,9])
console.log(tree)

var itree = invertTree(tree)
console.log("Inverted")
console.log(itree)