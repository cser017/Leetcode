class RandomizedSet {
    
    // val - location
    HashMap<Integer, Integer> locs;
    ArrayList<Integer> nums;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locs.containsKey(val)){
            return false;
        }
        int size = locs.size();
        locs.put(val, size);
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locs.containsKey(val)){
            return false;
        }
        int size = locs.size();
        int index = locs.get(val);
        // if val not the last element, switch with the last element
        if(index != size - 1){
            int last = nums.get(size - 1);
            locs.put(last, index);
            nums.set(index, last);
        }
        locs.remove(val);
        nums.remove(size - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */