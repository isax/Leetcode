public class ConvertSortedListtoBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        
        ListNode cur = head;
        int length = 0;
        while(cur!=null){
            cur = cur.next;
            length++;
        }
        return build(head, 0, length-1).root;
    }
    
    public static Element build(ListNode head, int left, int right){
		if(head==null||left>right){
			return new Element(head, null); //head, null
		}
	
		int mid = (left+right)/2;
		Element leftE = build(head, left, mid-1);
		head = leftE.head;//.next;
		TreeNode parent = new TreeNode(head.val);
		parent.left = leftE.root;
		head = head.next;
		Element rightE = build(head, mid+1, right);
		parent.right = rightE.root;
		
		return new Element(rightE.head, parent);
	}
}

class Element{
	ListNode head;
	TreeNode root;
	
	Element(){
		head = null;
		root = null;
	}
	
	Element(ListNode head, TreeNode root){
		this.head = head;
		this.root = root;
	}
}
