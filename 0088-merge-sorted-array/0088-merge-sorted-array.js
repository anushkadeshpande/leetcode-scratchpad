/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    
    let i = m - 1   // last position in nums1 with a non-zero value
    let j = n - 1   // last position in nums2 
    let k = m + n - 1
    while(j >= 0) {
        if(nums1[i] <= nums2[j] || i < 0) {
            nums1[k] = nums2[j]
            k--
            j--
        }
        else {
            // the number at i will be the greatest
            nums1[k] = nums1[i]
            i--;
            k--;
        }
    }
};