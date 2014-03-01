public class LongestConsecutiveSequence {
    /* 
     * Reference Link: 
     *  -http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/ 
     *  -http://blog.csdn.net/fightforyourdream/article/details/15024861
     * We can use a HashSet to add and remove elements. 
     * HashSet is implemented by using a hash table. 
     * Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).
     * After an element is checked, it should be removed from the set. 
     * Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i:num){
            hs.add(i);
        }
        int maxCount = Integer.MIN_VALUE;
        for(int i: num){
            if(hs.contains(i)){
                int count = 1;
                hs.remove(i);
                int prev = i-1;
                int next = i+1;
                
                while(hs.contains(prev)){
                    hs.remove(prev);
                    count++;
                    prev--;
                }
                
                while(hs.contains(next)){
                    hs.remove(next);
                    count++;
                    next++;
                }
                
                if(count>maxCount){
                    maxCount = count;
                }
                
            }
        }
        
        return maxCount;
    }
}
