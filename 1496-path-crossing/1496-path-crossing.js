/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {
    let pointsReached = {}
    
    let currentPosition = {
        'x': 0,
        'y': 0
    }
    
    pointsReached['0,0'] = 1
    
    path = path.split('')
    
    for(let point of path) {
        if(point === 'N')
            currentPosition.y += 1
        else if(point === 'S')
            currentPosition.y -= 1
        else if(point === 'E')
            currentPosition.x += 1
        else if(point === 'W')
            currentPosition.x -= 1
        
        if(pointsReached[currentPosition.x + ',' + currentPosition.y])
            return true
        else
            pointsReached[currentPosition.x + ',' + currentPosition.y] = 1
    }
    
    return false
};