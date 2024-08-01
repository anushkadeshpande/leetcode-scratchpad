class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    
    public void getCombinations(int[] candidates, int target, int idx, List<Integer> combination) {
        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        if(target < 0 || idx < 0) {
            return;
        }
        
        // include the current candidate
        combination.add(candidates[idx]);
        getCombinations(candidates, target-candidates[idx], idx, combination);
        
        // remove the added candidate
        combination.remove(combination.size() - 1);
        getCombinations(candidates, target, idx-1, combination);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombinations(candidates, target, candidates.length-1, new ArrayList<>());    
        
        return result;
    }
}