/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    // let start = 0
    // let end = 0
    // let max = 0
    // for(let i=1; i<height.length; i++) {
    //     max = Min(height[end], height[start]) * 
    // }
    
    // store the max height from left and right
    let leftMax = []
    let rightMax = []
    
    leftMax[0] = height[0]
    for(let i=1; i<height.length; i++)
        leftMax[i] = Math.max(leftMax[i-1], height[i]) 
    
    rightMax[height.length -1] = height[height.length - 1]
    for(let i=height.length-2; i>=0; i--)
        rightMax[i] = Math.max(rightMax[i+1], height[i])
    
    // find level at each bar (min of left and right)
    let level = []
    for(i=0; i<height.length; i++)
        level[i] = Math.min(leftMax[i], rightMax[i])
    
    // answer = sum(level - height)
    let answer = 0
    
    for(i=0; i<height.length; i++)
        answer += level[i] - height[i]
    
    return answer
};