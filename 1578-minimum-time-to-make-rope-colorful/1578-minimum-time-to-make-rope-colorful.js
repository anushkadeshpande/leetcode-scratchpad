/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */

const getMinTimeOutOfConsequtiveBalloons = (balloons, neededTime) => {
    // break the array into groups of consequtive balloons
    // iterate over the groups, and if groups consist > 1 element, return the one that takes min time
    let minTime = 0
    let sortedBalloons = balloons.reduce((result, currentNum, index) => {
    if (index === 0 || currentNum !== balloons[index - 1] + 1) {
      result.push([currentNum]);
    } else {
      result[result.length - 1].push(currentNum);
    }
    return result;
  }, []);
    
    for(let balloonGroup of sortedBalloons) {
        if(balloonGroup.length > 1) {
            // minTime +=  Math.max(...balloonGroup.map(b => neededTime[b]))
            // sort in descending order
            
            balloonGroup = balloonGroup.sort((a,b) => neededTime[b] - neededTime[a])
            balloonGroup.splice(0, 1)
            minTime += balloonGroup.reduce((sum, element) => sum += neededTime[element], 0)
            
        }
    }
    
    return minTime
}

var minCost = function(colors, neededTime) {
    // 2 consecutive balloons should not be of same color
    // time required should be min
    
    // 1. check if consecutive balloons have same color
    // 1.1. if not, return 0
    // 1.2. if it does, record its indices
        // maybe have a map, color: [positions]
    // if [positions].length > 1 for any of the balloons, take the time required for them to be removed
    // choose the min ones, add and return
    
//     let balloonsMap = {}
//     
//     for(let i=0; i<colors.length; i++) {
//         if(colors[i] in balloonsMap)
//             balloonsMap[colors[i]] = [...balloonsMap[colors[i]], i]
//         else
//             balloonsMap[colors[i]] = [i]
//     }
    
    let minTime = 0
    
  colors = colors.split('')
  let maxBalloonIdx = 0
  let maxBalloon = 0
  let currentPreviousBalloon = 0
  for(let i = 1; i<=colors.length; i++) {
      if(colors[currentPreviousBalloon] === colors[i]) {
          if(neededTime[currentPreviousBalloon] < neededTime[i])
          {
              maxBalloon += neededTime[currentPreviousBalloon]
              currentPreviousBalloon = i
          }
          else {
              maxBalloon += neededTime[i]
              // currentPreviousBalloon = i
          }
      } else currentPreviousBalloon = i      
  }
  
  return maxBalloon
};