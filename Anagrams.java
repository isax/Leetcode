public class Anagrams {
    
    /*
     * Reference Link: http://yucoding.blogspot.com/2012/12/leetcode-quesion-6-anagram.html
     *
     * Use one map <sorted string as the key,  position of the first string(unsorted)>, 
     * can deal with this problem more space efficiently. 
     * Check the array once, if the current string is not found in the map, then add <sorted string, current position>  into the map.         
     * If the current string can be found in the map, then add the current string in the result array, at this time, 
     * the first string of this anagram added in the map should also be put into the result array only once! 
     * Change the  map value can determine that.
     */
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i<strs.length; i++){
            String sorted = sort(strs[i]);
            if(!hm.containsKey(sorted)){
                hm.put(sorted, i);
            }else{
                int index = hm.get(sorted);
                if(index!=-1){
                    res.add(strs[index]);
                    hm.put(sorted, -1);
                }
                res.add(strs[i]);
            }
        }
        
        return res;
    }
    
    public String sort(String str){
        char[]charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
