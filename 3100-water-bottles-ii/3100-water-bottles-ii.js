/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var maxBottlesDrunk = function(numBottles, numExchange) {
    let emptyBottles = 0
    let bottlesDrunk = 0
    
    while(numBottles > 0 || emptyBottles >= numExchange) {
        // check if emptyBottles === numExchange
        // if true, exchange!
        if(emptyBottles > 0 && emptyBottles >= numExchange) {
            // exchange
            numBottles += 1
            emptyBottles -= numExchange
            numExchange ++
        } else {
            // drink
            bottlesDrunk += numBottles
            emptyBottles += numBottles
            numBottles = 0            
        }
    }
    
    return bottlesDrunk
};