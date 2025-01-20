class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }
        if(set1.size() < set2.size()) {
            return inter(set1,set2);
        } else {
            return inter(set2,set1);
        }

    }
    public int[] inter(Set<Integer> s1, Set<Integer> s2){
        int[] res = new int[s1.size()];
        int i = 0;
        for(Integer s: s1){
            if(s2.contains(s)){
                res[i++] = s;
            }
        }
        return Arrays.copyOf(res, i);
    }
}