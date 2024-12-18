class Solution {
    public int[] finalPrices(int[] prices) {
        // find the smaller element from right
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(n-1);
        answer[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i])
                stack.pop();
            
            if(!stack.empty()) {
                answer[i] = prices[i] - prices[stack.peek()];
            } else
                answer[i] = prices[i];
            stack.push(i);
        }
        
        return answer;
    }
}