class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!freqMap.containsKey(s.charAt(i)) || freqMap.get(s.charAt(i)) == 0) {
                return false;
            }
            freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) - 1);
        }
        return true;
    }
    
}
