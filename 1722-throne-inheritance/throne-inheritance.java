class ThroneInheritance {
    Map<String, List<String>> map = new HashMap<>();
    private Set<String> dead = new HashSet<>();
    private String king;
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        map.put(king, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, x -> new ArrayList<>());
        map.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(result, king);
        return result;
    }
    private void dfs(List<String> result, String root){
        if(!dead.contains(root)){
            result.add(root);
        }
        if(map.get(root) == null) return;

        for(String child: map.get(root)){
            dfs(result, child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */