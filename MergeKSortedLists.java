public class MergeKSortedLists {
    /*
     * Heap: Time: nlog(k) Space: O(k) n: # of all elements 
     * Merge 2 every time: Time: kn(logn) n: average length of list
     * Merge to the result list: Time: k^2*n = (1+2+3+..+k)n
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size()==0) return null;
        PriorityQueue<ListNode>queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
                public int compare(ListNode l1, ListNode l2){
                    if(l1.val<l2.val) return -1;
                    else if(l1.val>l2.val) return 1;
                    else return 0;
                }
            });
            
        for(ListNode list:lists){
            if(list!=null) queue.add(list);
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            if(temp.next!=null) queue.add(temp.next);
            cur = cur.next;
        }
        return newHead.next;
    }
}
