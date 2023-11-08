/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} fx
 * @param {number} fy
 * @param {number} t
 * @return {boolean}
 */
var isReachableAtTime = function(sx, sy, fx, fy, t) {
    // min time will be taken if we go via diagonal
    // num steps taken to go through the diagonal + remaining steps = num steps required
    // if num steps required <= t, true : false
    
    let xdiff = Math.abs(sx-fx)
    let ydiff = Math.abs(sy-fy)
    
    // if start and end are at same location and time = 1, it is impossible
    if(xdiff === 0 && ydiff === 0 && t === 1)
        return false
    
    return Math.min(xdiff, ydiff) + Math.abs(xdiff-ydiff) <= t
};