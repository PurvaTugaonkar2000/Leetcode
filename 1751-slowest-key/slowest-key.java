class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char slowestkey = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if(duration > maxDuration || (duration == maxDuration && keysPressed.charAt(i)> slowestkey)){
                maxDuration = duration;
                slowestkey = keysPressed.charAt(i);
            }
        }
        return slowestkey;
    }
}