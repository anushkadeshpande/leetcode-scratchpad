/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let mergedArray = [...nums1, ...nums2]
    
    mergedArray = mergedArray.sort((a,b) => a - b)
    if(mergedArray.length % 2 === 0)
    {
        return (mergedArray[Math.floor((mergedArray.length - 1) / 2)] + mergedArray[Math.ceil((mergedArray.length - 1) / 2)]) / 2
    }
    else
    {
        return mergedArray[Math.floor(mergedArray.length / 2)]
    }
        
};