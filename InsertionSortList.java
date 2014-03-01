public class InsertionSortList {
    /*
     * Reference Link: http://oj.leetcode.com/discuss/525/wrong-answer-input-3-2-1-output-1-3-2-expected-1-2-3
     */
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        // tempBefore->temp...->null   cur->next
        ListNode cur = head.next;
        head.next = null;
        while(cur!=null){
            ListNode next = cur.next;
            if(cur.val<head.val){ //insert before head
                cur.next = head;
                head = cur;
            }
            else{ // insert in the middle
                ListNode tempBefore = head;
                ListNode temp = head.next;
                
                while(temp != null && cur.val > temp.val){
                    tempBefore = temp;
                    temp = temp.next;
                }
                // tempBefore - cur - temp
                tempBefore.next = cur;
                cur.next = temp;
            }
            cur = next;
        }
        
        return head;
        
    }

}
