class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        List<Integer> disappearedNumbers = new ArrayList<>();

        for(int n: nums) {
            numbers.add(n);
        }

        for(int i=1; i<=nums.length; i++)
            if(!numbers.contains(i))
                disappearedNumbers.add(i);

        return disappearedNumbers;
    }
}