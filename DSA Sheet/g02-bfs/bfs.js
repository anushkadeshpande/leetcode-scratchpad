const findBfs = (v, graph) => {
    let queue = [];
    let traversal = [];
    let visited = [];
    for (let i = 0; i < v; i++) visited.push(0);
    queue.push(0);
    while (queue.length != 0) {
        let node = queue[0];
        if (visited[node] == 0) {
            traversal.push(node);

            visited[node] = 1;
            for (let i = 0; i < graph[node].length; i++) {
                queue.push(graph[node][i]);
            }
        }
        queue.splice(0, 1);
    }

    return traversal;
};

let v = 10;
let graph = [
    [2, 3, 4, 5, 6, 7],
    [2, 3, 4, 5, 7, 8],
    [3, 5, 7, 8, 9],
    [4, 7, 8, 9],
    [5],
    [7, 9],
    [8],
    [],
    [9],
    []
];

let bfs = findBfs(v, graph);

console.log(bfs);
