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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }
    
    public ListNode addHelper(ListNode l1, ListNode l2, int carry){
        if(l1==null&&l2==null&&carry==0) return null;
        
        int v1 = 0;
        int v2 = 0;
        
        if(l1!= null) v1 = l1.val;
        if(l2!= null) v2 = l2.val;
        
        int value = carry + v1 + v2;
        ListNode node = new ListNode(value%10);
        
        node.next = addHelper(l1==null?null:l1.next, l2==null?null:l2.next, value/10);
        
        return node;
    }
}
