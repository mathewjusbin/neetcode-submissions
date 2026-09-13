class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append('#').append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
List<String> resultString = new ArrayList<>();
        int i =0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));//This will give us the length
            //Then using the legth take the word
            j++;//j will be at the start of the next word
            String word = str.substring(j, j+length);
            resultString.add(word);
            i = j+length;
        }
        return resultString;
    }
}
