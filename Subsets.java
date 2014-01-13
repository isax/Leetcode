public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if(S==null) return null;
		
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> res = subsetsHelper(S, S.length-1);
		return res;
    }
	
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
}
