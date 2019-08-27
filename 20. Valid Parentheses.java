class Solution {
    
    private HashMap<Character, Character> mappings;
    
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
  }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(this.mappings.containsKey(c)){
               if(this.mappings.get(c) != (stack.empty() ? '#' : stack.pop())){
                   return false;
               }
            } else {
               stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}