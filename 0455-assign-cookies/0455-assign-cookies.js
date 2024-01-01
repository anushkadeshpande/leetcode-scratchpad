/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    // sort greed and cookie size
    // iterate through greed, if greed[i] <= s[j] then we move ahead to the next child and maintain a count
    
    g = g.sort((a, b) => a-b)
    s = s.sort((a, b) => a-b)

    let j = 0
    let i = 0 
    let count = 0
    while(i < g.length && j < s.length) {
        if(g[i] <= s[j]) {
            count ++
            i++
        }
        j++
    }
    
    return count
};