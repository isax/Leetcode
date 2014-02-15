public class SumRoot2LeafNumbers {
    public int sumNumbers(TreeNode root) {
        Sum sum = new Sum();
        helper2(root, sum, 0);
        return sum.val;
        //return helper(root, 0);
    }
    
    /*
     * While searching deeper, add the values up (times 10 + current value), 
     * and add the sum to final result if meet the leaf node (left and right child are both NULL).
     */
    public int helper(TreeNode root, int sum){
        if(root==null) return 0;
        
        int res = 10*sum + root.val;
        //base case
        if(root.left==null && root.right==null) return res;
        
        return helper(root.left, res) + helper(root.right, res);
    }
    
    public void helper2(TreeNode root, Sum sum, int val){
        if(root==null) return 0;
        
        int res = 10*val + root.val;
        if(root.left==null && root.right==null) {
            sum.val += res;
            return;
        }
        helper2(root.left, sum, res);
        helper2(root.right, sum, res);
    }
}

class Sum{
    int val;
}
