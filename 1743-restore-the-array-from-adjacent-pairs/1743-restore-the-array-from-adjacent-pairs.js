/**
 * @param {number[][]} adjacentPairs
 * @return {number[]}
 */
const dfs = (graph, startingVertex, answer, visited = {}) => {
    visited[startingVertex] = true;
    answer.push(parseInt(startingVertex, 10))
    for (const neighbor of graph[startingVertex]) {
      if (!visited[neighbor]) {
        dfs(graph, neighbor, answer, visited);
      }
    }
}

var restoreArray = function(adjacentPairs) {
    // build a graph
    let graph = {}
    
    for(let pair of adjacentPairs) {
        graph[pair[0]] = graph[pair[0]]? [...graph[pair[0]], pair[1]] : [pair[1]]
        graph[pair[1]] = graph[pair[1]]? [...graph[pair[1]], pair[0]] : [pair[0]]
    }
    
    // find the head node
    let head = null
    for(let node in graph) {
        if(graph[node].length === 1) {
            head = node
            break;
        }
    }
    
    // find the dfs of the graph
    let answer = []
    dfs(graph, head, answer)

    return answer;
};