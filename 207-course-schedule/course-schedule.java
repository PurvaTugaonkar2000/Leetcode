class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] prereq: prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for(int c = 0; c < numCourses; c++){
            if(!dfs(c, preMap, visited)) return false;
        }
        return true;

    }
    public boolean dfs(int course, Map<Integer, List<Integer> >preMap, Set<Integer> visited){
        if(visited.contains(course)) return false;
        if(preMap.get(course).isEmpty()) return true;
        visited.add(course);
        for(int pre: preMap.get(course)){
            if(! dfs(pre, preMap, visited)) return false;
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}