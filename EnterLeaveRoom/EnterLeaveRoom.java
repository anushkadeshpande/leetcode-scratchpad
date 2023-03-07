public class EnterLeaveRoom {

    public void calculateEnterLeaveRoom(String reqString) {
        int i = 0;
        
        int maxEnterLeave = reqString.length();
        int minEnterLeave = 0;
        int ans = 0;
        for (i=0; i<reqString.length(); i++) {
            if(reqString.charAt(i) == '1') {
                minEnterLeave++;
            }
            else if(reqString.charAt(i) == '0') {
                minEnterLeave--;
            }
           
            if(minEnterLeave < 0) {
                minEnterLeave = 0;
                ans += 1;
            }
            ans = Math.max(minEnterLeave, ans);

        }

        System.out.println("Max: " + maxEnterLeave);
        System.out.println("Min: " + ans);

    }

    public static void main(String[] args) {

        EnterLeaveRoom e = new EnterLeaveRoom();

        e.calculateEnterLeaveRoom("010");
    }
}
