public class strStrKMP {

    public String strStr(String haystack, String needle) {
        if(needle=="") return haystack;
        int [] next = buildNextTable(needle);
        int index = kmp(haystack, needle, next);
        
        if(index==-1) return null;
        else return haystack.substring(index);
    }
    
    public int kmp(String str, String ptrn, int []next){
        int i = 0;
        int j = 0;
        
        int s_len = str.length();
        int p_len = ptrn.length();
        
        while(i<s_len && j<p_len){ // not s_len-1 or p_len-1, cos need to compare p_len-1 to another char in haystack
            if(j==-1 || str.charAt(i)==ptrn.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        
        if(j >= p_len){
            return i - p_len;
        }else{
            return -1;
        }
        
    }
    
    public int [] buildNextTable(String str){
        int length = str.length();
        int [] next = new int[length];
        next[0] = -1;
        
        int j = -1;
        int i = 0;
        while(i < length - 1){ // just length -1
        // we are done with next[0]=-1, first iteration is to deal with next[1]
        // when i comes in, we are dealing with index i+1 this iteration.
            if(j==-1 || str.charAt(i)==str.charAt(j)){
                i++;
                j++;
                
                if(str.charAt(i)!=str.charAt(j)){
                    next[i] = j;
                }else{
                    next[i] = next[j];
                }
            }else{
                j = next[j];
            }
            
        }
        return next;
    }
}

