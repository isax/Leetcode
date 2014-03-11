public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {     
        if(S==null) return null;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = subsetsHelper(S, S.length-1);
        return res;
    }
    
    /*
     * Subsets of ArrayList which starts from 0 to index.
     */
    public static ArrayList<ArrayList<Integer>> subsetsHelper(int []S, int index){     
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(index<0) {
                ArrayList<Integer>subset = new ArrayList<Integer>();
                res.add(subset); //empty set
                return res;
        }

        int last = S[index];                
        ArrayList<ArrayList<Integer>> prev = subsetsHelper(S, index-1);                
        for(ArrayList<Integer>list: prev){                        
                res.add(list);
                ArrayList<Integer>addition = new ArrayList<Integer>();
                addition.addAll(list);//addAll: clone an arraylist        
                addition.add(last);
                res.add(addition);
        }
        
        return res;          
    }
    
    /*
     * Cleaner code, dfs + backtracking
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        subsetsHelper(S, 0, list, res);
        return res;
    }
	
	public void subsetsHelper(int []S, int index, ArrayList<Integer>list, ArrayList<ArrayList<Integer>> res){
	    if(index==S.length) return;
	    
	    for(int i = index; i<S.length; i++){
	        list.add(S[i]);
	        res.add((ArrayList)list.clone());
	        subsetsHelper(S, i+1, list, res);
	        list.remove(list.size()-1);
	    }
	}
    
    /*
     * My intuitive way of thinking: inefficient. Have to copy array every recursion. 
     */
    /*
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
    
    	if(S==null) return null;
    	Arrays.sort(S);         
    	ArrayList<ArrayList <Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(S.length==0) {
                ArrayList<Integer>subset = new ArrayList<Integer>();
                //subset.add(0);
                res.add(subset);
                return res;
        }
        
        int [] subS = new int[S.length-1];                
        for(int i = 0; i<S.length-1;i++){
                subS[i] = S[i];
        }
        
        int last = S[S.length-1];
        
        ArrayList<ArrayList<Integer>> prev = subsets(subS);
        
        for(ArrayList<Integer>list: prev){                        
                res.add(list);
                ArrayList<Integer>addition = new ArrayList<Integer>();
                addition.addAll(list);                        
                addition.add(last);
                res.add(addition);
        }       
        return res;   
    }*/
}
