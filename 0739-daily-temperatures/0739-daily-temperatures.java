class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // next greater element
        int n = temperatures.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            
            if(!stack.empty())
                answer[i] = stack.peek() - i;
            else
                answer[i] = 0;
            
            stack.push(i);
        }
        
        return answer;
    }
}