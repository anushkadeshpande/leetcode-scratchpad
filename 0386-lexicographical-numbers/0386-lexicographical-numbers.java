class Solution {
    List<Integer> numbers = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        
        
        int i = 1;
        
        addNumbersLexicographically(n, 1, 9);
        
        return numbers;
    }
    
    public void addNumbersLexicographically(int n, int start, int end) {
        while(start <= end && start <= n) {
            numbers.add(start);
            
            addNumbersLexicographically(n, start*10, (start*10) + 9);
            
            start++;
        }
    }
}