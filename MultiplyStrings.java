public class MultiplyStrings  {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuffer(num1).reverse().toString();
        String n2 = new StringBuffer(num2).reverse().toString();
        
        int l1 = n1.length();
        int l2 = n2.length();
        
        int[]res = new int[l1+l2];
        
        for(int i = 0; i<l1; i++){
            int digit1 = n1.charAt(i) - '0';
            int carry = 0;
            for(int j = 0; j<l2; j++){
                int digit2 = n2.charAt(j) - '0';
                int exist = res[i+j];
                int sum = digit1*digit2+carry+exist;
                res[i+j] = sum%10;
                carry = sum/10;
            }
            if(carry>0){ //456*3 = 1368 carry is the first 1
                res[i+l2] = carry;
            }
        }
        
        int index = l1+l2-1;
        while(index>= 0&& res[index]==0){
            index--;
        }
        
        if(index==-1) return new String("0");
        else{
            StringBuffer sb = new StringBuffer();
            for(;index>=0; index--){
                sb.append(res[index]);
            }
            return sb.toString();
        }
    }
}
