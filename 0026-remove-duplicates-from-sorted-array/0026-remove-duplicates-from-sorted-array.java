class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> occurrence = new ArrayList<>();
        
        for(int i=0; i< nums.length; i++) {
            if(occurrence.contains(nums[i])) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                occurrence.add(nums[i]);
            }
        }
        
        System.out.println(occurrence);
        
        Arrays.sort(nums);
        
        return occurrence.size();
    }
}