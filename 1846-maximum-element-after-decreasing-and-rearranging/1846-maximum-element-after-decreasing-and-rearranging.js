/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumElementAfterDecrementingAndRearranging = function(arr) {
    // sort array
    arr = arr.sort((a,b) => a - b) 
    
    // initial value
    let init = 0
    
    for(let i=0; i< arr.length; i++) {
        arr[i] = Math.min(arr[i], init+1)
        init = arr[i]
    }
    
    return arr[arr.length - 1]
};