public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode prev = tempHead;
        
        while(head!=null && head.next!=null){
            prev.next = head.next;
            head.next = head.next.next;
            prev.next.next = head;
            
            
            prev = prev.next.next;
            head = head.next;
        }
        
        return tempHead.next;
        
    }
}
