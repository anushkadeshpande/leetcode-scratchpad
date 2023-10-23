Write a function `bestSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.

If there is a tie for the shortest combination, you may return any one of the shortest.

    m: target sum
    n: numbers array length

1. Recursive Approach:
    -   Time Complexity: O(n ^ m * m) 
    -   Space Complexity: O(m^2)

2. Memoized Approach:
    -   Time Complexity: O(n * m ^ 2)
    -   Space Complexity: O(m ^ 2)