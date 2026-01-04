class Solution {
    public int sumFourDivisors(int[] nums) {
        // we need to get divisors of every number from nums
        int totalSum = 0;
        for(int n: nums) {
            int count = 0;
            int sum = 0;

            for(int d=1; d * d <=n; d++) {
                if(n % d == 0) {
                    int j = n / d;

                    count++;
                    sum += d;

                    if(j != d) {
                        count++;
                        sum += j;
                    }

                    if(count > 4)
                        break;
                }
            }

                if(count == 4)
                    totalSum += sum;
            }

        return totalSum;
    }
}