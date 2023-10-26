Write a function `allConstruct(target, wordBank)` that accepts a target string and an array of strings.

The function should return a 2D array containing all of the ways that the `target` can be constructed by concatenating elements of the `wordBank` array. Each element of the 2D array should represent one combination that constructs the `target`.

You may reuse elements of `wordBank` as many times as needed.

    m: target string length
    n: strings array length

1. Recursive Approach:
    -   Time Complexity: O(n ^ m) 
    -   Space Complexity: O(m)

2. Memoized Approach:
    -   Time Complexity: O(n ^ m)
    -   Space Complexity: O(m)