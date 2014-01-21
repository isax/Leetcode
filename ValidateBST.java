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
}
