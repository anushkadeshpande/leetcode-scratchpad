class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailAddresses = new HashSet<>();
        
        for(String email: emails) {
            String[] emailParts = email.split("@");
            
            String firstPart = "";
            for(int i=0; i<emailParts[0].length(); i++) {
                if(emailParts[0].charAt(i) == '+')
                    break;
                else if(emailParts[0].charAt(i) != '.')
                    firstPart += emailParts[0].charAt(i);
            }
            
            emailAddresses.add(firstPart + "@" + emailParts[1]);
        }
        
        return emailAddresses.size();
    }
}