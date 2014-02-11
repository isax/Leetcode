public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        
        String prefix = strs[0];
        for(int i = 1; i<strs.length; i++){
            int length = prefix.length();
            if(length==0) return "";
            
            if(length<=strs[i].length() && strs[i].substring(0, length).equals(prefix)){
                continue;
            }else{
                StringBuffer temp = new StringBuffer();
                for(int j = 0; j<length&&j<strs[i].length(); j++){
                    if(prefix.charAt(j)==strs[i].charAt(j)){
                        temp.append(prefix.charAt(j));
                    }else{
                        break;
                    }
                }
                prefix = temp.toString();
            }
        }
        return prefix;
    }
    
    public String longestCommonPrefix2(String[] strs) {
        if(strs==null||strs.length==0) return "";
         
        for(int i = 0; i<strs[0].length(); i++){
            char cur = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=cur){
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}
