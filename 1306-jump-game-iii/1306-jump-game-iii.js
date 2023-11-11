/**
 * @param {number[]} arr
 * @param {number} start
 * @return {boolean}
 */
var canReach = function(arr, start) {
    let queue = []
    queue.push(start)

    while(queue.length !== 0)
    {
        let size = queue.length

        while(size-- > 0) {
            let point = queue.splice(0,1)
            
            // moving to left

            let leftIdx = +point - +arr[point]
            if(leftIdx >= 0) {
                if(arr[leftIdx] == 0) {
                    return true
                }
                if(arr[leftIdx] > 0) {
                    queue.push(leftIdx)
                }
            } 

            // moving to right
            let rightIdx = +point + +arr[point]
            if(rightIdx < arr.length) {
                if(arr[rightIdx] == 0) {
                    return true
                }
                if(arr[rightIdx] > 0) {
                    queue.push(rightIdx)
                }
            }
            
            
            arr[point] = -1
        }
    }
    return false

};