class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        int prev = -1;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                if(prev == -1){
                    maxDist = i;
                } else {
                    maxDist = Math.max(maxDist, (i - prev)/2);
                }
                prev = i;
            }
        }
        maxDist = Math.max(maxDist, seats.length - 1 - prev);
        return maxDist;
    }
}