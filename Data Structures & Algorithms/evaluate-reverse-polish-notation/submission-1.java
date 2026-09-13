class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    result.push(result.pop()+result.pop());
                    break;
                case "*":
                    result.push(result.pop()*result.pop());
                    break;
                case "-":
                    int second = result.pop();
                    int first = result.pop();
                    result.push(first - second);
                    break;
                case "/":
                    int secondDiv = result.pop();
                    int firstDiv = result.pop();
                    result.push(firstDiv / secondDiv);
                    break;
                default:
                    result.push(Integer.parseInt(token));
            }
        }
        return result.pop();
    }
}
