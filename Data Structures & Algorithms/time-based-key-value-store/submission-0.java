class TimeMap {
HashMap<String, TreeMap<Integer,String>> dataMap;
    public TimeMap() {
                dataMap = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        dataMap.putIfAbsent(key, new TreeMap<Integer,String>());
        dataMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if (!dataMap.containsKey(key)) {
            return "";
        }

        Integer timeStamp = dataMap.get(key).floorKey(timestamp);
        if (timeStamp == null) {
            return "";
        }

        return dataMap.get(key).get(timeStamp);
    }
}
