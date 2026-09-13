class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
       int maxLength = 0;
       HashSet<Character> resultSet = new HashSet<>();
       for (int right = 0; right < s.length(); right++) {
           Character currentChar = s.charAt(right);


           /*
            * A duplicate makes the current window invalid.
            *
            * Keep removing characters from the left until the old occurrence
            * of currentChar is removed. This must be 'while', not 'if':
            *
            * Window "pw", current character = 'w'
            * Remove 'p' first -> old 'w' is still in the window.
            * Remove 'w' next -> duplicate is gone.
            */


           while (resultSet.contains(currentChar)) {
               resultSet.remove(s.charAt(left));
               left++;
           }
           // The window is valid again, so include the current character.
           resultSet.add(currentChar);
           // '+1' because both left and right indexes belong to the window.
           int currentLength = (right - left) + 1;
           // Preserve the longest valid substring found anywhere in the string.
           maxLength = Math.max(currentLength, maxLength);//cuz longest string
       }
       return maxLength;

    }
}
