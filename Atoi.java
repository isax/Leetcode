public class Atoi {
    public static int atoi(String str) {
        if(str==null) return 0;
        
        int sign = 1;
        int num = 0;
        
        int index = 0;
        while(index<str.length()&&str.charAt(index)==' '){
            index++;
        }
        if(index==str.length()) return 0;
        
        if(str.charAt(index) =='+') index++;
        if(str.charAt(index) =='-') {
            sign = -1;
            index++;
        }
        
        for(; index<str.length(); index++){
            char c = str.charAt(index);
            if( c<'0' || c>'9' ){
                break;
            }else if(Integer.MAX_VALUE/10<num || Integer.MAX_VALUE/10==num && Integer.MAX_VALUE%10 < c - '0'){
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            num = num*10 + c - '0';
        }
        return num*sign;
    }
    
    public static void main(String[]args){
    	System.out.println(atoi("123"));
    	System.out.println(atoi("-123"));
    	System.out.println(atoi("  "));
    	System.out.println(atoi(""));
    	System.out.println(atoi(" 123"));
    	System.out.println(atoi(" +123 "));
    	System.out.println(atoi(" -123"));
    	System.out.println(atoi(" -1 23 "));
    	System.out.println(atoi("123d"));
    	System.out.println(atoi("-123"));
    	System.out.println(atoi("-123f"));
    	System.out.println(atoi("   -  "));
    	System.out.println(atoi("   --1  "));
    	System.out.println(atoi("   ++1  "));
    }
}
