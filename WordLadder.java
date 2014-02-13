public class WordLadder {
    public int ladderLength(String start, String stop, HashSet<String> dict) {
        if(start==null||stop==null) return 0;
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        HashMap<String, String> backTrackMap = new HashMap<String, String>();
        
        queue.add(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            String cur = queue.poll();
            for(String oneEditWord: getOneEditWords(cur)){
                
                if(oneEditWord.equals(stop)){ // find our word 
                    int num = 1;
                    while(cur!=null){
                        num++;
                        cur = backTrackMap.get(cur);
                    }
                    return num;
                }
                // not stop
                if(dict.contains(oneEditWord)){
                    if(!visited.contains(oneEditWord)){
                        backTrackMap.put(oneEditWord, cur);
                        visited.add(oneEditWord);
                        queue.add(oneEditWord);
                    }
                }
            }
            
        }
        return 0;
        
    }
    
    public static Set<String> getOneEditWords(String word){
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i<word.length(); i++){
            char []charArrays = word.toCharArray();
            char cur = charArrays[i];
            for(char c = 'a'; c<='z'; c++){
                if(c!=cur) {
                    charArrays[i] = c;
                    hs.add(String.valueOf(charArrays));
                }
            }
        }
        return hs;
    }
}
