public class FlattenBST2SingleLL {
    public void flatten(TreeNode root) {
        if(root==null) return;

        helper2(root);
  
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
            //leftSub.head.left = root;
            tail = leftSub.tail;
        }

        NodePair rightSub = helper(r);
        if(rightSub!=null){
        	if(leftSub!=null){
        		leftSub.tail.right = rightSub.head;
                        //rightSub.head.left = leftSub.tail;
        	}else{
        		root.right = rightSub.head;
        		//rightSub.head.left = root;
        	}   
        	tail = rightSub.tail;
        }
                
        return new NodePair(root, tail);
    }
    
    public static TreeNode helper2(TreeNode root){
        if(root==null) return null;
        
        TreeNode l = root.left;
        TreeNode r = root.right;
        
        
        TreeNode leftSub= null;
        TreeNode leftTail = null;
        if(l!=null){
            leftSub = helper2(l);
            leftTail = getTail(leftSub);
            root.right = leftSub;
            //leftSub.left = root;
            
        }
        
        root.left =null;
        
        TreeNode rightSub= null;
        if(r!=null){
            rightSub = helper2(r);
            if(leftSub!=null){
                leftTail.right = rightSub;
                //rightSub.left = leftTail;
            }else{
                root.right = rightSub;
                //rightSub.left = root;
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
    
    /*******************static variable***********************/
    public static TreeNode lastVisited = null;
    public static void helper3(TreeNode root){
        if(root==null) {
        	return;
        }
        
        TreeNode r = root.right;
        
        if(lastVisited!=null){
            lastVisited.right = root;
            lastVisited.left = null;
        }
        lastVisited = root;
        
        helper3(root.left);
        helper3(r); // have to save root.right, cos lastVisited.right = root.
    }
    
    /*
     * Use a Wrapper Class
     */
    public static void helper4(TreeNode root, Wrapper wr){
        if(root==null) {
        	return;
        }
        
        TreeNode r = root.right;
        
        if(wr.lastVisited!=null){
            wr.lastVisited.right = root;
            wr.lastVisited.left = null;
        }
        wr.lastVisited = root;
        
        helper4(root.left, wr);
        helper4(r, wr); // have to save root.right, cos lastVisited.right = root.
    }
    
    /******************* Iterative: DFS(Pre-order) ***********************/
    /******************* Stack ***********************/
    public void flattenStack(TreeNode root) {
        if(root==null) return;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode lastVisited = null;
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(lastVisited!=null){
                lastVisited.left = null;
                lastVisited.right = node;
            }
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
            lastVisited = node;
        }
  
    }
    
}

class Wrapper{
    TreeNode lastVisited = null;
}

class NodePair{
    TreeNode head;
    TreeNode tail;
    
    NodePair(TreeNode head, TreeNode tail){
        this.head = head;
        this.tail = tail;
    }
    
    NodePair(){
        head = null;
        tail = null;
    }
}
