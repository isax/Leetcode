public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n || head==null || head.next==null) return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode p = newHead;
        
        int i = 1;
        while(i!=m){
            p = p.next;
            i++;
        }
        
        int k = n-m;
        ListNode q = p.next;
        
        while(k>0){
            ListNode temp = q.next;
            q.next = temp.next;
            temp.next = p.next;
            p.next = temp;
            k--;
        }
        
        return newHead.next;
    }
}
