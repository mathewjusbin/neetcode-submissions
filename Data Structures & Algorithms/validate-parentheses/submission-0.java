class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c== '[' || c== '{'){
                characterStack.push(c);
            }else{
                if(characterStack.isEmpty()){
                    return false;
                }
                char top = characterStack.pop();
                if(c == ')' && top != '(')return false;
                if(c == ']' && top != '[')return false;
                if(c == '}' && top != '{')return false;
            }
        }
        return characterStack.isEmpty();// false if any opening brackets were never closed
    }
}
