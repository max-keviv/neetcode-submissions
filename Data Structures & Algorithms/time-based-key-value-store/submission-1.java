class TimeMap {
    HashMap<String,List<Pair<Integer,String>>> keyValMap;
    public TimeMap() {
        keyValMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer,String> val = new Pair<Integer,String>(timestamp,value);
        if(keyValMap.get(key)==null)
        {
            keyValMap.put(key,new ArrayList<>());
        } 
        keyValMap.get(key).add(val);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = keyValMap.get(key);
        if(values == null) return "";
        int low = 0, high = values.size() - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(values.get(mid).getKey() == timestamp) return values.get(mid).getValue();
            else if(values.get(mid).getKey() < timestamp) low = mid + 1;
            else high = mid - 1;
        }
        if(high<0)
            return "";
        return values.get(high).getValue();
    }
}
