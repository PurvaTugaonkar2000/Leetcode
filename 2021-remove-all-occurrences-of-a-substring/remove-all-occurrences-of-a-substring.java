class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int partstartidx = s.indexOf(part);
            s = s.substring(0, partstartidx) + 
            s.substring(partstartidx + part.length());
        }
        return s;
    }
}