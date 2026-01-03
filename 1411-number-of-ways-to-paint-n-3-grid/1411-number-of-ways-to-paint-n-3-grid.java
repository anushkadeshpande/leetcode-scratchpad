class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        long x = 6, y = 6;
        
        for (int i = 2; i <= n; i++) {
            long new_x = (3 * x + 2 * y) % MOD;
            long new_y = (2 * x + 2 * y) % MOD;
            x = new_x;
            y = new_y;
        }
        
        return (int)((x + y) % MOD);
    }
}

// 1 - 3 * 2 * 2
// 2 - 3 * 2 * 2 * 2 * 1 * 1 -- 96

// ABA or ABC only 2 patterns possible

// ABC
// BAC