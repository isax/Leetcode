public class Solution {
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newHead = head;
        
        int last = head.val;
        ListNode lastNode = head;
        head = head.next;
        
        while(head!=null){
            if(head.val==last){
                lastNode.next = head.next;
                
            }else{
                last = head.val;
                lastNode = head;
            }
            head = head.next;
        }
        return newHead;
    }
    
    public ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode newHead = head;
        
        while(head.next!=null){
            if(head.val==head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return newHead;
    }
}
