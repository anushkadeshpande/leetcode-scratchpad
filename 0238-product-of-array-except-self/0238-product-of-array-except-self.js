/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let answers = Array(nums.length).fill(1)
    
    // find the product of all elements before the current element
    // PRE-PRODUCT
    // the 1st element will always have pre-product as 1
    answers[0] = 1
    for(let i=1; i<nums.length; i++) {
        answers[i] = answers[i-1] * nums[i-1]
    }
            
    // find the product of all elements after current element
    // POST-PRODUCT
    // last element will always have post-product as 1, hence retaining the value of pre-product
    let postProduct = 1
    for(let i=nums.length - 1; i >= 0; i--) {
        answers[i] = answers[i] * postProduct
        postProduct *= nums[i]
    }   
    return answers
};