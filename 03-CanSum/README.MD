Write a function `canSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.

You may use an element of the array as many times as needed.

You may assume that all input numbers are nonnegative.


1. Recursive Approach:
    -   Time Complexity: O(n ^ m)
    -   Space Complexity: O(m)

2. Memoized Approach:
    -   Time Complexity: O(m * n)
    -   Space Complexity: O(m)

3. Tabulated Approach:
    -   Time Complexity: O(m * n)
    -   Space Complexity: O(m)