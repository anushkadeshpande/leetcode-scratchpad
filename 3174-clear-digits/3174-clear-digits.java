class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.pop();
            } else
                stack.push(c);
        }        
        
        String res = "";
        List<Character> chars = new ArrayList<>();
        
        while(!stack.empty())
            chars.add(stack.pop());
        
        
        for(int i=chars.size() - 1; i >= 0; i--) {
            res += chars.get(i);
        }
        return res;
    }
}