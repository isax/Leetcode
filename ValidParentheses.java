public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isLeft(ch)){
                stack.push(ch);
            }else {
                if(stack.isEmpty()) return false;
                
                char left = stack.peek();
                if(ifMatch(left, ch)) stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    public boolean isLeft(char ch){
        if(ch=='(' || ch=='{' || ch =='['){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ifMatch(char l, char r){
        if(l=='(' && r==')' || l =='{' && r =='}'|| l =='[' && r ==']'){
            return true;
        }else{
            return false;
        }
    }
}
