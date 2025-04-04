class SnapshotArray {
    List<TreeMap<Integer, Integer>> history;
    int snapId;
    public SnapshotArray(int length) {
        history = new ArrayList<>();
        snapId = 0;;
        for(int i = 0; i < length; i++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0,0);
            history.add(map);
        }
    }
    
    public void set(int index, int val) {
        history.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return history.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */