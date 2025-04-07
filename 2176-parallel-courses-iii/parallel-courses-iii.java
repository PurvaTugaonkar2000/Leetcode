class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> memo = new HashMap<>();
    public int minimumTime(int n, int[][] relations, int[] time) {
        for(int i = 1; i <=n; i++){
            map.put(i, new ArrayList());
        }
        for(int[] relation: relations){
            map.get(relation[1]).add(relation[0]);
        }
        int minTime = 0;
        for(int course = 1; course <=n; course++){
            minTime = Math.max(minTime, dfs(course, time));
        }
        return minTime;

    }
    public int dfs(int course, int[] time){
        if(memo.containsKey(course)){
            return memo.get(course);
        }
        if(map.get(course) == null){
            return time[course];
        }
        int result = 0;
        for(int neighbor: map.get(course)){
            result = Math.max(result, dfs(neighbor, time));
        }
        memo.put(course, result + time[course - 1]);
        return time[course - 1] + result;
    }
}