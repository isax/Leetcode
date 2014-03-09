public class RemoveNthNodeFromEndofList  {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        
        ListNode left = head;
        ListNode right = head;
        
        int count = 0;
        while(count<n){
            right = right.next;
            count++;
        }
        
        while(right!=null){
            right = right.next;
            prev = left;
            left = left.next;
        }
        prev.next =left.next;
        return newHead.next;
    }
}
