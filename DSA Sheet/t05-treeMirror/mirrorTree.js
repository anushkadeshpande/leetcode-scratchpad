function Node(data, left, right) {
  this.data = data === undefined ? 0 : data;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

let constructTree = (nodes) => {
  let root = new Node();
  root.data = nodes[0];
  let queue = [];
  queue.push(root);

  let i = 1;
  let node = null;
  while (queue.length != 0) {
    node = queue[0];
    queue.splice(0, 1);

    if (i <= nodes.length - 1) {
      node.left = new Node(nodes[i++]);
      queue.push(node.left);
    }

    if (i <= nodes.length - 1) {
      node.right = new Node(nodes[i++]);
      queue.push(node.right);
    }
  }
  return root
};

let mirrorTree = (root) => {
    let mirroredRoot = new Node()
    // mirroredRoot.data = root.data

    let pointer = root
    let mirrorPointer = mirroredRoot
    let queue = []
    let mirroredQueue = []
    queue.push(pointer)
    mirroredQueue.push(mirrorPointer)
    let mirroredNodes = []
    while(queue.length != 0)
    {
        pointer = queue[0]
        mirrorPointer = mirroredQueue[0]
        mirrorPointer.data = pointer.data
        mirroredNodes.push(mirrorPointer.data)
        queue.splice(0, 1)
        mirroredQueue.splice(0,1)

        if(pointer.right) {
            // mirrorPointer.left = pointer.right
            mirrorPointer.left = new Node()

            queue.push(pointer.right)
            mirroredQueue.push(mirrorPointer.left)

        }

        if(pointer.left) {
            // pointer = pointer.left
            mirrorPointer.right = new Node()
            queue.push(pointer.left)
            mirroredQueue.push(mirrorPointer.right)
        }

        
    }

    return mirroredNodes
}

let tree = constructTree([2, 3, 4, 5, 6])
let mirroredTree = mirrorTree(tree)
console.log(mirroredTree)