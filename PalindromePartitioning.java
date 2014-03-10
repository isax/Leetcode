public class PalindromePartitioning {
    /*
     * Reference Link: http://yucoding.blogspot.com/2013/08/leetcode-question-132-palindrome.html
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        int length = s.length();
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();

        partitionHelper(s, 0, list, lists);
        return lists;
    }
    
    public void partitionHelper(String str, int start, ArrayList<String> list, ArrayList<ArrayList<String>> lists) {
        if(start==str.length()) {
            lists.add((ArrayList)list.clone());
            return;
        }
        for(int i = start; i<str.length();i++){
            if(ifPalin(str, start, i)) {
                list.add(str.substring(start, i+1));
                partitionHelper(str, i+1,list, lists);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean ifPalin(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
