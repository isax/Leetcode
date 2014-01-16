/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class PartitionList {
	
	/*
	 * If current node value < x, then cur = cur.next; 
	 * if current node value >=x, then move this node to the end of the list.
	 */
	public static ListNode partitionBetter(ListNode head, int x){
		if(head==null) return head;
		ListNode right = head;
		
		int size = 1;
		while(right.next!=null){
			size++;
			right = right.next;
		}
		
		ListNode newHead = new ListNode(0); // add a new head
		newHead.next = head;
		head = newHead;

		ListNode before = head;
		ListNode cur = head.next;

		
		while(size>0){
			if(cur.val>=x){
				ListNode newNode = new ListNode(cur.val);
				right.next = newNode;
				right = newNode;
				
				before.next = cur.next;
				cur = cur.next;
			}			
			else{
				before = before.next;
				cur = cur.next;
			}
			size--;
			
		}
		return head.next;
		
	}
  
	
   public static ListNode partitionIntuitive(ListNode head, int x) {
		ListNode firstStart = null;
		ListNode firstEnd = null;
		ListNode secondStart = null;
		ListNode secondEnd = null;
        
		while(head!=null){
			ListNode next = head.next;
			head.next = null;
					
			if(head.val < x){
				if(firstStart==null){
					firstStart = head;	
					firstEnd = firstStart;
				}else{
					firstEnd.next = head;
					firstEnd = head;				
				}				
			}
			else{
				if(secondStart==null){
					secondStart = head;	
					secondEnd = secondStart;
					
				}else{
					secondEnd.next = head;
					secondEnd = head;				
				}
			}
			
			head = next; //head.next;
		}
		//if(secondEnd!=null) secondEnd.next = null; // otherwise, when list=[2,1] x=2 will cause a cyle
		
		if(firstStart==null) return secondStart;
		
		firstEnd.next = secondStart;
		return firstStart;  
        
    } 
    
    /*
     * Instable. Cannot pass all test cases.
     */
    public static ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode left = head;
        while(left!=null&&left.val<x) {
        	left = left.next;
        }
        if(left==null||left.next==null) return head;
        	
        ListNode right = left.next;
        while(right!=null){
        	if(right.val<x) {
        		int temp = left.val;
        		left.val = right.val;
        		right.val = temp;
        		left = left.next;
        	}
        	right = right.next;	
        }
        return head;
    }
}
