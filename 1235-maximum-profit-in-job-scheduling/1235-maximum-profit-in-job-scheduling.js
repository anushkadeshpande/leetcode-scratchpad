/**
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @param {number[]} profit
 * @return {number}
 */

let buildJobsArray = (startTime, endTime, profit) => {
    let jobs = []
    
    for(let i=0; i<startTime.length; i++) {
        jobs.push({
            start: startTime[i],
            end: endTime[i],
            profit: profit[i]
        })
    }
    
    return jobs
}



var jobScheduling = function(startTime, endTime, profit) {
    let maxProfit = 0
    
    
    // create array of obj with startTime, endTime and profit
    // sort according to endTime
    
    let jobs = buildJobsArray(startTime, endTime, profit)
    
    jobs = jobs.sort((jobA, jobB) => jobA.start - jobB.start)
    
    // let profit = 0
    let maximizeProfit = (index, memo = {}) => {
        // for every index, we either inculde it or don't include it
        
        if(index >= jobs.length)
            return 0
        
        if(index in memo)
            return memo[index]
        
        
        // don't include the current job
        // so move on to the next job
        maxProfit = maximizeProfit(index + 1, memo)
        
        // choose the current job
        // add its profit
        // and choose the next job with startTime >= jobs[index].end
        let nextJobIdx = index + 1
        while(nextJobIdx < jobs.length) {
            if(jobs[nextJobIdx].start >= jobs[index].end)
                break
            nextJobIdx++
        }
        
        maxProfit = Math.max(maxProfit, jobs[index].profit + maximizeProfit(nextJobIdx, memo))
        memo[index] = maxProfit
        return maxProfit
    }
    
    // for(let i = 0; i< startTime.length; i++) {
    //     maxProfit = Math.max(maxProfit, maximizeProfit(i, startTime, endTime, profit))    
    // }
    
    return maximizeProfit(0)
};