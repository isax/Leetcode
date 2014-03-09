public class ConstructBTfromInandPost{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        else return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[]inorder, int[]postorder, int inst, int inend, int post, int poend){
        if(inst>inend || post>poend ) return null;
        int rootValue = postorder[poend];
        int rootIndex = 0;
        
        for(int i = inst; i<=inend; i++){
            if(inorder[i]==rootValue) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(inorder, postorder, inst, rootIndex-1, post, post+rootIndex-1-inst);
        root.right = helper(inorder, postorder, rootIndex+1, inend, post+rootIndex-inst, poend-1);
        return root;
    }
}
