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
}
