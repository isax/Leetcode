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
}
