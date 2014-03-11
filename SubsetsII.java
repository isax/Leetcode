public class SubsetsII  {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>());
        
        subsetsHelper(num, 0, list, res);
        return res;
    }
    
    public void subsetsHelper(int []num, int index, ArrayList<Integer>list, ArrayList<ArrayList<Integer>> res){
	    if(index==num.length) return;
	    
	    for(int i = index; i<num.length; i++){
	        list.add(num[i]);
	        res.add((ArrayList)list.clone());
	        subsetsHelper(num, i+1, list, res);
	        list.remove(list.size()-1);
	        
	        while(i<num.length-1 && num[i+1]==num[i]){
	            i++;
	        }
	    }
	}
}
