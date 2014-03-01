public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        char [] chars = s.toCharArray();
        int length = s.length();
        int count = 0;
        for(int i = length-1; i>=0; i--){
            if(chars[i]!=' ') count++;
            
            if(chars[i]==' ' && count!=0){ // not the last ' '
                return count;
            }
        }
        
        return count;
    }
    
}
