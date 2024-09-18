class Solution {
    public String largestNumber(int[] nums) {
        // convert integer to string
        int n = nums.length;
        String[] numsString = new String[n];
        for(int i=0; i<n; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        
        // sort 
        Arrays.sort(numsString, new Comparator<String>() {
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                
                return str2.compareTo(str1);
            }
        });
        
        // for(String s: numsString)
            // System.out.println(s);
        
        if(numsString[0].equals("0"))
            return "0";
        // append
        String ans = "";
        for(String s: numsString) 
            ans = ans + s;
        
        return ans;
    }
}