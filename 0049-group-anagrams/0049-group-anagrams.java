class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sort each of the string
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> groups = new ArrayList<>();
        for(String str: strs) {
            // System.out.println(Arrays.sort(str.toCharArray()));
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            ArrayList<String> groupMembers;
            
            if(map.containsKey(key)) {
                groupMembers = map.get(key);
                groupMembers.add(str);
                map.put(key, groupMembers);
            } else {
                groupMembers = new ArrayList<>();
                groupMembers.add(str);
                map.put(key, groupMembers);
            }
        }
        
        for(String key: map.keySet())
            groups.add(map.get(key));
        return groups;
    }
}