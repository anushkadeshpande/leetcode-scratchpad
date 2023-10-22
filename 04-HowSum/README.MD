Write a function `howSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

The function should return an array containing any combination of elements that add up to exactly the targetSum. 

If there is no combination that adds up to the targetSum, then return null.

If there are multiple combinations possible, you may return any single one.


1. Recursive Approach:
    -   Time Complexity: O(n ^ m + m)    ------ + m for array update operation
    -   Space Complexity: O(m)

2. Memoized Approach:
    -   Time Complexity: O(n * m ^ 2)
    -   Space Complexity: O(m ^ 2)