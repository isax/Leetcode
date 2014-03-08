public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        int count = 0;
        ListNode cur  = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        helper(head, count);
    }
    
    public ListNode helper(ListNode head, int length) {
        if(length==1){
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }else if(length==2){
            ListNode temp = head.next.next;
            head.next.next =null;
            return temp;
        }else{
            ListNode node = helper(head.next, length-2);
            ListNode next = node.next;
            node.next = head.next;
            head.next = node;
            return next;
        }
    }
}
