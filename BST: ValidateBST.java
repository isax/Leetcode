public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
                ArrayList<Integer>a = new ArrayList<Integer>();
		inorder(root, a);
		
		for(int i = 1; i<a.size(); i++){
			if(a.get(i-1)>=a.get(i)) return false;
		}
		return true;
    }
    
    public static void inorder(TreeNode root, ArrayList<Integer>a){
		if(root==null) return;
		inorder(root.left, a);	
		a.add(root.val);
		inorder(root.right, a);	
    }
    
 
    /*
     * 34 / 54 test cases passed...Have no idea!!
     */
    static int lastCheck = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
                if(root==null) return true;
		
		if(!isValidBST(root.left)) return false;
		
		if(root.val<=lastCheck){
		    lastCheck = root.val;
			return false;
		}
		lastCheck = root.val;
		if(!isValidBST(root.right)) return false;
		
		return true;
    }
    
    /*
     * Wrapper Class
     */
    
    public static boolean checkBST3(TreeNode root, Wrapper wr){
		if(root==null) return true;
		
		if(!checkBST3(root.left, wr)) return false;
		
		if(root.val<=wr.value){
			return false;
		}
		wr.value = root.val;
		if(!checkBST3(root.right, wr)) return false;
		
		return true;
    }
    
    public boolean isValidBST(TreeNode root) {
                Wrapper wr = new Wrapper(Integer.MIN_VALUE);
		return checkBST3(root, wr);
    }
}

class Wrapper{
	int value;
	Wrapper(int value){
		this.value = value;
	}
}
