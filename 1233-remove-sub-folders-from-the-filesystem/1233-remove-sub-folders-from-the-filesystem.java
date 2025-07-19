class Solution {
    public List<String> removeSubfolders(String[] folder) {

        // sort the array
        // check if previous is substring of current string
        // add to res if not

        List<String> parentFolders = new ArrayList<String>();

        Arrays.sort(folder);
        parentFolders.add(folder[0]);
        int idx = 0;
        for(int i=1; i<folder.length; i++) {
            String prevFolder = parentFolders.get(idx);

            if(!folder[i].startsWith(prevFolder) 
            || folder[i].length() < prevFolder.length() 
            || folder[i].charAt(prevFolder.length()) != '/') {
                parentFolders.add(folder[i]);
                idx++;
            }
        }

        return parentFolders;
    }
}