class Solution {
    public int arrangeCoins(int n) {
//         int cnt = 0;
//         int i = 1;
//         while(n > 0) {
//             n -=i;
//             if(n >= 0)
//                 cnt++;
//             i++;
//         }
        
//         return cnt;
        
        // !USING GAUSS FORMULA
        return (int) (Math.sqrt(1 + 8 * (long) n) - 1 ) / 2;
    }
}