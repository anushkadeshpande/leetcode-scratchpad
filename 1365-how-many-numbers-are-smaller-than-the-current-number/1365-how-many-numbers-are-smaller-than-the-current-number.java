class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // sort the array
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        // store the index in hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // store the index in hashmap
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(temp[i]))
                map.put(temp[i], i);
        }

        // build result
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            result[i] = map.get(nums[i]);
        return result;
    }
}