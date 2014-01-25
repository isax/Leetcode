public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        else return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left==right&&left==null) return true;
        if(left==null||right==null||left.val!=right.val) 
           return false;
        return helper(left.left, right.right)&&helper(left.right, right.left);
    }

    /*
	 * Just list a wrong in-order method here.
	 * In-order is not a solution for this problem.
	 * It will return true for unsymmetric test cases like this: {1,2,3,3,#,2,#}
	 * The res list is: -2147483648 3 -2147483648 2 -2147483648 1 -2147483648 2 -2147483648 3 -2147483648
	 * which is symmetric.
	 */
	public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        ArrayList<Integer>list = new ArrayList<Integer>();
        inorder(root, list);
        
        int i = 0;
        int j = list.size()-1;
        
        while(i!=j){
            int left = list.get(i);
            int right = list.get(j);
            if(left!=right) 
               return false;
            i++; j--;
        }
        return true;
    }
    
    public static void inorder(TreeNode root, ArrayList<Integer>list){
        if(root==null){
            list.add(Integer.MIN_VALUE);
            return;
        }
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list); 
    }
}
