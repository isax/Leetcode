public class ReverseInteger {
    public int reverse(int x) {
        if(x<0) return -1*reverse(-1*x);
        
        int res = 0;
        while(x!=0){
            int i = x%10;
            res = res*10 + i;
            
            x = x/10;
        }
        return res;
    }
}
