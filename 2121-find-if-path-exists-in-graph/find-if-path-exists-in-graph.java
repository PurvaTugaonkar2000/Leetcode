class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;
            for(int nei : adjList.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
        return false;
    }
}