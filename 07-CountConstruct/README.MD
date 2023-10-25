Write a function countConstruct(target, wordBank)` that accepts a target string and an array of strings.

The function should return the number of ways that the `target` can be constructed by concatenating elements of the wordBank` array.

You may reuse elements of `wordBank` as many times as needed.

    m: target string length
    n: strings array length

1. Recursive Approach:
    -   Time Complexity: O(n ^ m * m) 
    -   Space Complexity: O(m^2)

2. Memoized Approach:
    -   Time Complexity: O(n * m ^ 2)
    -   Space Complexity: O(m ^ 2)