/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    let time = 0

    // APPROACH - 2    
    // before k, we'll reduce k number of times
    // after k, we'll reduce k-1 times
    
    for(let i=0; i<tickets.length; i++) {
        if(i <= k) {
            time += Math.min(tickets[i], tickets[k])
        } else {
            time += Math.min(tickets[i], tickets[k] - 1)
        }
    }
    
    return time
    
    // APPROACH-1
    
    // while(tickets[k] !=0) {
    //     for(let i=0; i<tickets.length; i++) {
    //         if(k === i && tickets[i] === 1) {
    //             time++
    //             return time
    //         }
    //         else if(tickets[i] >0) {
    //             tickets[i] -=1
    //             time++
    //         }
    //     }
    // }
};