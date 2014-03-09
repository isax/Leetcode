public class RecoverBinarySearchTree {
    
    public void recoverTree(TreeNode root){
        if(root==null) return;
        Wrapper wr = new Wrapper();
        helper(root, wr);
        
        int temp = wr.n1.val;
        wr.n1.val = wr.n2.val;
        wr.n2.val = temp;
    }
    
    public void helper(TreeNode root, Wrapper wr){
        if(root==null) return;
        helper(root.left, wr);
        if(wr.lv!=null && root.val<wr.lv.val) {
            if(wr.n1==null){
                wr.n1 = wr.lv;
            }
            wr.n2 = root; // cannot pass {0,1}: else wr.n2 = root. 
            //Attention: must assign root to n2 in case they are next to each other 
        }
        wr.lv = root;
        helper(root.right,wr);
    } 
}

class Wrapper {
    TreeNode lv;
    TreeNode n1;
    TreeNode n2;
}
