class Solution {
    static boolean[] isPrime = new boolean[5_000_001];
    
    public Solution() {
        System.out.println("Counting ");
        for(int i = 2; i*i <= 5_000_000; i++){
            
            if(isPrime[i] == false){
                for(int j = i * i; j <= 5_000_000; j += i){
                    isPrime[j] = true;
                }
            }
        }
    }
    
    public int countPrimes(int n) {
        int count = 0;
        for(int i=2; i<n; i++) {
            if(!isPrime[i])
                count++;
        }
        
        return count;
    }
}