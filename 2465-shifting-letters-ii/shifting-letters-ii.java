class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[s.length()];
        for(int[] shift: shifts){
            if(shift[2] == 1){
                diff[shift[0]]++;
                if(shift[1] + 1 < n){
                    diff[shift[1] + 1]--;
                }
            } else{
                diff[shift[0]]--;
                if(shift[1] + 1 < n){
                    diff[shift[1] + 1]++;
                }
            }
        }
        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diff[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}