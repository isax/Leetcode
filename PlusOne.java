public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if(digits[length-1]!=9){
            digits[length-1] += 1;
            return digits;
        }else{
            int index = length-1;
            while(index>=0 && digits[index]==9){
                digits[index] = 0;
                index--;
            }
            if(index>=0) {
                digits[index] += 1;
                return digits;
            }
            else{
                int [] res = new int[length+1];
                res[0] = 1;
                return res;
            }
        }
    }
}
