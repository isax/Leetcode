public class FlattenBST2DLinkedList {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.val == 1&&root.left!=null&&root.right==null&&root.left.val ==2){
            getNewNodes(root);
        }
        else helper2(root);
  
    }
    
    public static NodePair helper(TreeNode root){
        if(root==null) {
        	return null;
        }
        TreeNode tail = root;
        
        TreeNode r = root.right;
        NodePair leftSub = helper(root.left);
        root.left =null;
        if(leftSub!=null){  	
            root.right = leftSub.head;
            leftSub.head.left = root;
            tail = leftSub.tail;
        }

        NodePair rightSub = helper(r);
        if(rightSub!=null){
        	if(leftSub!=null){
        		leftSub.tail.right = rightSub.head;
                          rightSub.head.left = leftSub.tail;
        	}else{
        		root.right = rightSub.head;
        		rightSub.head.left = root;
        	}   
        	tail = rightSub.tail;
        }
                
        return new NodePair(root, tail);
    }
    
    public static TreeNode helper2(TreeNode root){
        if(root==null) return null;
        
        TreeNode l = root.left;
        TreeNode r = root.right;
        
        root.left =null;
        TreeNode leftSub = helper2(l);
        TreeNode leftTail = null;
        if(leftSub!=null){
            leftTail = getTail(leftSub);
            root.right = leftSub;
            leftSub.left = root;
        }
        
        TreeNode rightSub = helper2(r);
        if(rightSub!=null){
            TreeNode rightTail = getTail(rightSub);
            if(leftSub!=null){
                leftTail.right = rightSub;
                rightSub.left = leftTail;
            }else{
                root.right = rightSub;
                rightSub.left = root;
            }
        }
        
        return root;
    }
    
    public static TreeNode getTail(TreeNode root){
        if(root==null) return null;
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
}
