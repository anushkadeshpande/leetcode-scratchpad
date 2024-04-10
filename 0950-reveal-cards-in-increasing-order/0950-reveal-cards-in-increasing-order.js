/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function(deck) {
    const sorted = deck.sort((a,b)=>a-b)

    const result = [sorted.pop()]

    while(sorted.length){
        result.unshift(result.pop())
        result.unshift(sorted.pop())
    }
    
    return result  
};