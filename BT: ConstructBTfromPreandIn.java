public class ConstructBTfromPreandIn{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        else return helper(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    
    public TreeNode helper(int[]preorder, int[]inorder, int inst, int end, int prest, int preend){
        if(inst>end|| prest>preend) return null;
        int rootValue = preorder[prest];
        int rootIndex = 0;
        
        for(int i = inst;i<=end; i++){
            if(inorder[i]==rootValue){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, inorder, inst, rootIndex-1, prest+1, prest+rootIndex-inst);
        root.right = helper(preorder, inorder, rootIndex+1, end, prest+rootIndex-inst+1, preend);
        return root;
    }
}
