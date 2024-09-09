class Solution {
    public boolean checkMatch(String s, String p, int sIndex, int pIndex) {
//         if(sIndex == s.length() && pIndex == p.length())
//             return true;
        
//         if(pIndex > s.length())
//             return false;
        
//         boolean match = false;
        
//         // either the character matches or there is a dot
//         if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
//             match = true;
//         }
        
//         // even if the character matched, if the next char is * 
//         // we either consider it or ignore it
//         if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
//             return (match && checkMatch(s, p, sIndex+1, pIndex)) || checkMatch(s,p,sIndex,pIndex+2);
//         } 
        
//         if(match)
//             return checkMatch(s, p, sIndex+1, pIndex+1);
        
        // if char match go ahead
        // if dot, skip one char
        // if *, either use it or ignore it
        if(sIndex >= s.length() && pIndex >= p.length())
            return true;
        if(pIndex >= p.length())
            return false;
        boolean match = false;
        if(sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex))
            match = true;
        else if(sIndex < s.length() && p.charAt(pIndex) == '.')
            match = true;
        
        if(pIndex+1 < p.length() && p.charAt(pIndex+1) == '*')
            return (match && checkMatch(s, p, sIndex+1, pIndex)) || checkMatch(s, p, sIndex, pIndex+2);
        
        
        if(match == true)
            return checkMatch(s, p, sIndex+1, pIndex+1);
        
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return checkMatch(s, p, 0, 0);
//         int j = 0;
//         for(int i=0; i<p.length(); i++) {
//             char regExChar = p.charAt(i);
//             char stringChar = s.charAt(j);
            
//             if(i != p.length() -1 && p.charAt(i+1) == '*'){
//                 char previousChar;
//                 // if(i != 0) {
//                 previousChar = p.charAt(i); 
//                 char nextChar;
                
//                 nextChar = p.charAt(i+1);
//                 // } else {
//                     // previousChar = '.';
//                 // }
//                 if(previousChar == '.' && Character.isAlphabetic(nextChar))
//                     return true;
                
//                 else
//                 // System.out.println(previousChar);
                
//                 while(j < s.length() && s.charAt(j) == previousChar) {
//                     j++;
//                 }
//                 // System.out.println(j);
//                 i++;
//             } 
            
//             else if(Character.isAlphabetic(regExChar) && regExChar == stringChar)
//                 j++;
//             else if(regExChar == '.')
//                 j++;
//             // else if(regExChar == '*')
//             else
//                 return false;
//         }
        
//         if(j < s.length())
//             return false;
        
//         return true;
    }
}