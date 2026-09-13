class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String word = new String(charArray);
            wordMap.putIfAbsent(word, new ArrayList<>());
            wordMap.get(word).add(str);
        }
        return new ArrayList<>(wordMap.values());
    }
}
