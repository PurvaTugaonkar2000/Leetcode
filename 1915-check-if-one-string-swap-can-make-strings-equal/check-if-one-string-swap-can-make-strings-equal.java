class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int firstIdx = 0;
        int secondIdx = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;

            if(count > 2) {return false;}
            else if (count == 1){
                firstIdx = i;
            } else {
                secondIdx = i;
            }
            }
        }
        return (s1.charAt(firstIdx) == s2.charAt(secondIdx) &&
        s1.charAt(secondIdx) == s2.charAt(firstIdx)
        );
    }
}