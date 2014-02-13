public class strStrSuffixTree {
    public static String strStr(String haystack, String needle) {
        
        SuffixTree tree = new SuffixTree();
        tree.insertString(haystack);
        
        int index = tree.search(needle);
        System.out.println(index);
        if(index==-1) return null;
        else return haystack.substring(index);
        
    }
    
    public static void main(String[]args){
    	String haystack = "abcabcd";
    	String needle = "bc";
    	System.out.println(strStr(haystack, needle));
  	
    }
}

class SuffixTree{
    SuffixTreeNode root = new SuffixTreeNode();
    
    public void insertString(String str){
        for(int i = 0; i < str.length(); i++){
            String substr = str.substring(i);
            root.insert(substr, i);
        }
    }
    
    public int search(String str){
        return root.search(str);
    }
}

class SuffixTreeNode{
    HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
    int index = -1;
    
    public void insert(String str, int index){
    	if(str==null) return;
    	if(this.index==-1){
            this.index = index; 
         }
        if(str.length()==0) return;  
        
        if(children.containsKey(str.charAt(0))){
            String substr = str.substring(1);
            System.out.println(str.charAt(0) +"  containskey");
            children.get(str.charAt(0)).insert(substr, index);
        }else{
            SuffixTreeNode newChild = new SuffixTreeNode();
            children.put(str.charAt(0), newChild);
            System.out.println(str.charAt(0) +"  new child");
            newChild.insert(str.substring(1), index);
        }
    }
    
    public int search(String str){
    	if(str==null || str.length()==0) return index;
        
        if(children.containsKey(str.charAt(0))){
            String substr = str.substring(1);          
            return children.get(str.charAt(0)).search(substr);
        }else{
            return -1;
        }
    }
}
