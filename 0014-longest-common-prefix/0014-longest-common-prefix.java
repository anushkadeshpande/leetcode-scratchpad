class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        String prefix = "";
        int count = 0;
        if(strs.length == 1 && strs[0].equals(""))
            return "";
        if(strs.length == 1)
            return  strs[0];
        if(Arrays.stream(strs).anyMatch(""::equals))
            return "";
        while(true) {
       for(int i=1; i<strs.length; i++) {
           if(idx >= strs[i].length() || idx >= strs[i-1].length())
               return prefix;
           if(strs[i-1].charAt(idx) != strs[i].charAt(idx))
              return prefix;
           count ++;
           if(count == strs.length - 1)
            {
               // reset count
               count = 0;
               
               // add the common char to prefix
               prefix += strs[i].charAt(idx);
               
               // check next idx
               idx ++;
               }
           }
            }
       
    }
}