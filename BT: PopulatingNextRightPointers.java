public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        iterative(root);
    }
    
     public void iterative(TreeLinkNode root){
        while(root!=null){
            TreeLinkNode thisLevel = root;
            while(thisLevel!=null){
                if(thisLevel.left!=null){
                    thisLevel.left.next = thisLevel.right;
                }
                if(thisLevel.right!=null && thisLevel.next!=null){
                    thisLevel.right.next = thisLevel.next.left;
                }
                thisLevel = thisLevel.next;
            }
            root = root.left;
        }
    }
    
    public void connectElegant(TreeLinkNode root){
        if(root==null) return;
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null){
            root.right.next = root.next==null?null:root.next.left;
        }
        
        connectElegant(root.right);
        connectElegant(root.left);
    }

    public void connectRecursion(TreeLinkNode root) {
        if(root==null) return;
        
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        
        if(left!=null && right!=null){
            left.next = right;
        }else {
            return;
        }
        
        while(left.right!=null){
            left = left.right;
            right = right.left;
            left.next = right;
        }
        
        connectRecursion(root.left);
        connectRecursion(root.right);
        
    }
    
    
    /*
     * Use the property of perfect BT
     */
    public void connectBF2(TreeLinkNode root) {
        if(root==null) return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        int level = 1;
        int no = 1;
        
        while(!q.isEmpty()){
            //ArrayList<TreeLinkNode> temp= new ArrayList<TreeLinkNode>();
            //temp = (ArrayList)q.clone();
            //q.clear();
            TreeLinkNode node = q.remove();
            
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
            
            if(no==Math.pow(2,level-1)){
                no=1;
                level++;
                node.next=null;
            }else{
                no++;
                node.next = q.peek();
            }
            
        }
        
    }
    
    /*
     * Naive BFS
     */
    public void connectBF(TreeLinkNode root) {
        if(root==null) return;
        ArrayList<TreeLinkNode> q = new ArrayList<TreeLinkNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            ArrayList<TreeLinkNode> temp= new ArrayList<TreeLinkNode>();
            temp = (ArrayList)q.clone();
            q.clear();
            
            for(int i = 0; i<temp.size(); i++){
                TreeLinkNode node = temp.get(i);
                if(i==temp.size()-1){
                    node.next = null;
                }
                else{
                    node.next = temp.get(i+1);
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            
        }
        
    }
}
