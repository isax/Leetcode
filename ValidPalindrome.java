public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0) return true;
        
        s = s.toLowerCase();
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left<right){
            while(left<right && !isAlphaNum(s.charAt(left))){
                left++;
            }
            while(left<right && !isAlphaNum(s.charAt(right))){
                right--;
            }
            
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
        
    }
    
    public boolean isAlphaNum(char ch){
        if(ch>='a' && ch<='z') return true;
        if(ch>='0' && ch<='9') return true;
        return false;
    }
}
