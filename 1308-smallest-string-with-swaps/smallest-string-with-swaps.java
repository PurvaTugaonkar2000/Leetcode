class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        if(n <= 1 || pairs.isEmpty()) return s;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++) parent[i] = i;

        for(List<Integer> pair: pairs){
            int a = pair.get(0), b = pair.get(1);
            union(a,b, parent, rank);
        }

        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i < n; i++){
            int root = find(i, parent);
            groups.computeIfAbsent(root, k-> new ArrayList<>()).add(i);
        }

        char[] result = s.toCharArray();

        for (List<Integer> idxList : groups.values()) {
            List<Character> chars = new ArrayList<>();
            for (int idx : idxList) {
                chars.add(result[idx]);
            }

            Collections.sort(idxList);      // sort positions
            Collections.sort(chars);        // sort chars

            for (int i = 0; i < idxList.size(); i++) {
                result[idxList.get(i)] = chars.get(i);
            }
        }

        return new String(result);


    }

    private int find(int i, int[] parent){
        if(parent[i] != i) parent[i] = find(parent[i], parent);

        return parent[i];
    }
    private void union (int a, int b, int[] parent, int[] rank){
        int ra = find(a, parent);
        int rb = find(b, parent);

        if(ra == rb) return;

        if(rank[ra] < rank[rb]) parent[ra] = rb;
        else if(rank[rb] > rank[ra]) parent[rb] = ra;
        else{
            parent[rb] = ra;
            rank[ra]++;
        }
    }
}