class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> reminders = new HashMap<>();

        reminders.put(0, -1);

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];
            int key = prefixSum % k;

            if(reminders.containsKey(key))
            {
                if(i - reminders.get(key) > 1)
                {
                    return true;
                }
            }
            else
            {
                reminders.put(key, i);
            }
        }

        return false;
    }
}