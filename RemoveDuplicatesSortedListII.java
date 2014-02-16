public class Solution {
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prevNode = newHead;
        ListNode nextNode = head.next;
        
        while(nextNode!=null){
            if(head.val!= nextNode.val){
                head = head.next;
                prevNode = prevNode.next;
                nextNode = nextNode.next;
            }else{
                while(nextNode!=null && head.val==nextNode.val){
                    nextNode = nextNode.next;
                }
                prevNode.next = nextNode;
                head = nextNode;
                if(nextNode==null) break;
                else nextNode = nextNode.next;
            }
        }
        return newHead.next;
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode prevNode = newHead;
        
        while(head.next!=null){
            if(head.val!= head.next.val){
                head = head.next;
                prevNode = prevNode.next;
            }else{
                while(head.next!=null && head.val==head.next.val){
                    head = head.next;
                }
                prevNode.next = head.next;
                if(head.next==null) break;
                else head = head.next;
            }
        }
        return newHead.next;
    }
}
