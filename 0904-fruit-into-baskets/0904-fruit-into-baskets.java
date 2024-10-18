class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int end = 0;
        int n = fruits.length;
        
        Map<Integer, Integer> uniqueFruits = new HashMap<>();
        
        int maxFruits = 0;
            
        while(start < n && end < n) {
            if(uniqueFruits.size() == 2 && !uniqueFruits.containsKey(fruits[end])) {
                // resize the window
                int qty = uniqueFruits.get(fruits[start]);
                if(qty == 1)
                    uniqueFruits.remove(fruits[start]);
                else
                    uniqueFruits.put(fruits[start], qty-1);
                start++;
            } else {
                uniqueFruits.put(fruits[end], uniqueFruits.computeIfAbsent(fruits[end], x -> 0) + 1);
                end++;
                maxFruits = Math.max(maxFruits, uniqueFruits.keySet().stream().reduce(0, (acc, key) -> acc + uniqueFruits.get(key))); 
            }
            
        }
        
        return maxFruits;
    }
}