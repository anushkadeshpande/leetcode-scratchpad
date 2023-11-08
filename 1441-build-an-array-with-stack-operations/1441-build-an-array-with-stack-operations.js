/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    let stack = []
    let sol = []
    for(let i = 1; i <= n; i++) {
        stack.push(i)
        sol.push("Push")
        if(!target.includes(i))
        {
            stack.pop()
            sol.push("Pop")
        }
        if( target.every((val, index) => val === stack[index]))
            return sol;
    }
    return sol
};