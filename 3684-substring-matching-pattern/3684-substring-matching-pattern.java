class Solution {
    public boolean hasMatch(String s, String p) {
        // find position of * in p
        int starPos = p.indexOf('*');

        if(starPos != -1) {

            // match all characters before *
            // check if pattern before * is present in the original string or not 
            int beforeStar = s.indexOf(p.substring(0, starPos));

            // match all characters after *
            // search only in the string that follows the before star part
            int afterStar = s.indexOf(p.substring(starPos+1), beforeStar + starPos);

            if(beforeStar != -1 && afterStar != -1)
                return true;
        }
        return false;
    }
}