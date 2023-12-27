/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */

var minCost = function(colors, neededTime) {
    // 2 consecutive balloons should not be of same color
    // time required should be min
    
    colors = colors.split('')
    let maxBalloon = 0
    let currentPreviousBalloon = 0
    for(let i = 1; i<=colors.length; i++) {
        if(colors[currentPreviousBalloon] === colors[i]) {
            if(neededTime[currentPreviousBalloon] < neededTime[i])
            {
                maxBalloon += neededTime[currentPreviousBalloon]
                currentPreviousBalloon = i
            }
            else
                maxBalloon += neededTime[i]
        } 
        else 
            currentPreviousBalloon = i      
  }
  
  return maxBalloon
};