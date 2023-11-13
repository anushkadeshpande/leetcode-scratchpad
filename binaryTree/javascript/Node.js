function Node(data, left, right) {
    this.data = data
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

const binaryTree = new Node(1, new Node(2, new Node(3), new Node(4)), new Node(5, null, new Node(6)))

console.log(binaryTree)