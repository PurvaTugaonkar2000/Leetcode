class Solution {
    public boolean isAnagram(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        String s1 = new String(char1);
        String s2 = new String(char2);
        if(s1.equals(s2)) return true;
        return false;
    }
}