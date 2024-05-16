class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if(memo.containsKey(n))
            return memo.get(n);
        if(n == 0)
            return 0;
        
        if(n <= 2)
            return 1;
        
        int fib = fib(n-1) + fib(n-2);
        memo.put(n, fib);
        return fib;
    }
}