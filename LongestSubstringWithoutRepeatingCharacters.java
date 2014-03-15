public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        int maxLength = 0;
        int curLength = 0;
        int startPos = 0;
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!hm.containsKey(c) || hm.get(c)<startPos){
                curLength++;
                hm.put(c, i);
                
            }else{
                curLength = i - hm.get(c);
                startPos = hm.get(c)+1;
                hm.put(c, i);
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
        
    }
}
