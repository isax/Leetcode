public class CopyListwithRandomPointer {

    /*
     * Reference Link: http://yucoding.blogspot.com/2013/12/leetcode-question-copy-list-with-random.html
     *
     * This problem returns a new linked list, which has the same value and structure of the original one. 
     * First we can create a new linked list without considering the Random pointer, which is straight forward:  Scan every node in the original list and create the new list.
     * But how to keep the random pointer also correct ? 
     * If we only point the new random pointer to the original random pointer, which is not a deep copy (since the deletion of nodes in original list will delete the new one as well).  
     * So, how to memorize the relative position of the random node to the current node? 
     * Firstly I think to use the length from head node to the random node. For each node, I stored the position of its random node, same position node in the new list is the random node for the node in the new list. This idea can work, but is not efficient. 
     * For every node you have to search from the start to the end to find the random, the total complexity is O(n^2). 
     * Can we quickly locate the position of the node?  
     * Yes!  Hash map!  A map with the node as key and node as the value can finish the job! 
     * We can use the original list node as the key, and the same node in the new list as the value.  
     * Now the map[node_old] = node_new, therefore the node_new->random = map[node_old->random]. 
     *In this way, the complexity decreases to O(n).
     */
     
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode newPrev = new RandomListNode(0);
        RandomListNode cur = newPrev;
        RandomListNode old = head;
        while(old!=null){
            cur.next = new RandomListNode(old.label);
            hm.put(old, cur.next);
            cur = cur.next;
            old = old.next;
        }
        
        cur = newPrev.next;
        while(head!=null){
            cur.random = hm.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        return newPrev.next;
    }
}
