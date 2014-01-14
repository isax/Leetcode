public class LRUCache {

	Node head, tail;
	HashMap<Integer, Node> directory;
	int capacity = 0;

	public LRUCache(int capacity) {
        this.capacity = capacity;
        directory = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
	
	/*
	 * move used node to the end of the linked list
	 */
	public void moveNode(Node target){
		if(target==tail) return; // tail: do nothing
		
		if(target==head) { //head and >=1 node
			head = target.next;
			target.next.prev = null;
			
			tail.next = target;
			target.prev = tail;
			tail = target;			
		}
		else { // in the middle
			target.next.prev = target.prev;
			target.prev.next = target.next;
			
			tail.next = target;
			target.prev = tail;
			tail = target;
		}	
	}
	
	public void insertNode(Node target){
		if(head==null) {
			head = target;
			tail = target;
		}else{
			tail.next = target;
			target.prev = tail;
			tail = target;
		}
	}
	
	/*
	 * remove head
	 */
	public void removeHead(){ 
		if(head==null) return;
		else if(head==tail){
			head = null;
			tail = null;
		}
		else{
			head = head.next;
			head.prev = null;
		}
	}
    
	/*
	 * set method
	 */
    public int get(int key) {
        if(!directory.containsKey(key)) 
        	return -1;
        else{
        	Node target = directory.get(key);
        	moveNode(target);
        	return target.value; 
        }
    }
    
    /*
	 * get method
	 */
    public void set(int key, int value) {
        if(directory.containsKey(key)){
        	Node node = directory.get(key);
        	node.value = value; // just change the value here, no need to do any change in hashmap
        	moveNode(node);
        }
        else {
        		
        	if(directory.size()==capacity){ //check the capacity
        		directory.remove(head.key); // remove LRU(head) in list and map
        		removeHead();
        	} 
        	//insert new node to list and map
        	Node newNode = new Node(value, key);    		
    		directory.put(key, newNode);
    		insertNode(newNode);

        }
    }
    
    class Node{
    	int value;
    	int key;
    	Node next, prev;
    	public Node(int value, int key){
    		this.value = value;
    		this.key = key;
    		this.prev = null;
    		this.next = null;
    	}
    }
}


