public class PalindromeNumber {
    public boolean isPalindrome2(int x) {
        if(x<0) return false;
        int reverse = 0;
        int y = x;
        while(x>0){
            reverse = reverse*10 + x%10;
            x = x/10;
        }
        return (reverse==y);
    }
    
    public boolean isPalindrome3(int x) {
        if(x<0) return false;
        int div = 1;
        while(x/div>=10){
            div = div*10;
        }
        while(x>0){
            int i = x/div;
            int j = x%10;
            if(i!=j) return false;
            x = x%div/10;
            div = div/100;
        }
        
        return true;
    }
    
    public boolean isPalindrome(int x){
        if(x<0) return false;
        Wrapper wr = new Wrapper();
        wr.i = x;
        return isPalindromeRecursive(wr, x);
    }
    
    /*
     * Reference Link: http://yucoding.blogspot.com/2013/04/leetcode-question-62-palindrome-number.html
     *
     */
    public boolean isPalindromeRecursive(Wrapper wr, int y) {
        if(y==0){
            return true;
        }
        
        if(isPalindromeRecursive(wr, y/10)){
            if(y%10==wr.i%10){
                wr.i = wr.i/10;
                return true;
            }
        }
        return false;
    }
}

class Wrapper{
    int i;
}
