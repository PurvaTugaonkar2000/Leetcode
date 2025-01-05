class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }
    private void dfs(int[] nums, int idx, List<List<Integer>> res, List<Integer> subset){
        if(idx == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        dfs(nums, idx + 1, res, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, idx + 1, res, subset);
    }
}