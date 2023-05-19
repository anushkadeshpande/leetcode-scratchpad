function Node(data, left, right) {
  this.data = data === undefined ? 0 : data;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

const buildTree = (str) =>{
  // Corner Case
  if (str.length === 0 || str[0] === "N") return null;

  // Create the root of the tree
  let root = new Node(parseInt(str[0]));

  // Push the root to the queue
  let queue = [];
  let start = 0;
  queue.push(root);

  // Starting from the second element
  let i = 1;
  while (queue.length !== start && i < str.length) {
    // Get and remove the front of the queue
    let currNode = queue[start];
    start++;

    // Get the current node's value from the string
    let currVal = str[i];

    // If the left child is not null
    if (currVal !== "N") {
      // Create the left child for the current node
      currNode.left = new Node(parseInt(currVal));

      // Push it to the queue
      queue.push(currNode.left);
    }

    // For the right child
    i++;
    if (i >= str.length) break;
    currVal = str[i];

    // If the right child is not null
    if (currVal !== "N") {
      // Create the right child for the current node
      currNode.right = new Node(parseInt(currVal));

      // Push it to the queue
      queue.push(currNode.right);
    }
    i++;
  }

  return root;
}

const levelOrder = (node) => {
  let queue = [];
  let traversal = [];
  queue.push(node);

  while (queue.length != 0) {
    node = queue[0];
    queue.splice(0, 1);
    traversal.push(node.data);

    if (node.left != null) 
      queue.push(node.left);
    if (node.right != null) 
      queue.push(node.right);
  }

  return traversal;
};

var tree = buildTree([10, 20, 'N' , 30, 40, 60]);

let levelOrderTraversal = levelOrder(tree);

console.log(levelOrderTraversal);
