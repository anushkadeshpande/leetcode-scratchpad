class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int tribonacci(int n) {
        Integer val = memo.get(n);
        if(val != null)
            return val;
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        memo.put(n, tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3));
        
        return memo.get(n);
    }
}