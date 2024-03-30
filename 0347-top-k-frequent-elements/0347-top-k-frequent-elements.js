/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    // find frequency of elements
    // if frequency == k, add that element to results array
    
    let frequencyMap = new Map()
    let kFreqElements = []
    
    for(let num of nums) {

        frequencyMap.set(num, frequencyMap.get(num) + 1 || 1)
        
    }
    let arr = Array.from(frequencyMap.entries());
    arr.sort((a,b) => b[1] - a[1]);
    console.log(arr)
    for (let i = 0; i < k; i++) {
        kFreqElements.push(arr[i][0]);
    }
    
    return kFreqElements
};