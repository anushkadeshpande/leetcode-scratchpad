class Solution {
    // List<Integer> numbers = new ArrayList<>();
    int num = 0;
    public int findKthNumber(int n, int k) {
        // find k lexicographic elements from 1
        // getKthLexicographicNumber(n, 1, 9, k);
        // // return it
        // return num;
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++;
                k -= step;
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }

        return curr;
    }
    
//     public void getKthLexicographicNumber(int n, int start, int end, int k) {
       
//         while(start <= end && start <= n) {
//             // numbers.add(start);
//             // count++;
//             k--;
//             if(k == 1)
//                 num = start;
               
//             getKthLexicographicNumber(n, start*10, (start*10) + 9, k);
            
//             start++;
//         }
//         // return 0;
//         // if(start == n)
//             // num = start; 
//     }
    
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}