class TimeMap {
class Data{
    Integer timeStamp;
    String state;
    Data(Integer timeStamp, String state){
        this.timeStamp = timeStamp;
        this.state = state;
    }
}
HashMap<String, List<Data>> stringdataHashMap;
    public TimeMap() {
        stringdataHashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(timestamp,value);
        stringdataHashMap.putIfAbsent(key, new ArrayList<>());
        stringdataHashMap.get(key).add(data);
    }
    
    public String get(String key, int timestamp) {
        String answer = "";
        if(!stringdataHashMap.containsKey(key)){
            return answer;
        }

        List<Data> list = stringdataHashMap.get(key);
        int left =0;
        int right = list.size()-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(list.get(mid).timeStamp == timestamp){
                return list.get(mid).state;
            } else if (list.get(mid).timeStamp <= timestamp) {
                answer = list.get(mid).state;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return answer;
    }
}
