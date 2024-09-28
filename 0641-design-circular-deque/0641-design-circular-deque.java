class MyCircularDeque {
    
    public class Node {
        int data;
        Node link = null;
        
        public Node(int data, Node next) {
            this.data = data;
            this.link = next;
        }
    }
    
    Node head;
    int size = 0;
    int currSize = 0;

    public MyCircularDeque(int k) {
        this.head = null;
        this.size = k;
    }
    
    public boolean insertFront(int value) {
        if(currSize < size) {
            Node temp = new Node(value, head);
            head = temp;
            currSize ++;
            return true;
        }
        
        return false;
    }
    
    public boolean insertLast(int value) {
        if(currSize < size) {
            Node newNode = new Node(value, null);
            Node temp = head;
            if(head == null) {
                head = newNode;
            } else {
                while(temp.link != null) {
                    temp = temp.link;
                }
            
                temp.link = newNode;
            } 
            currSize++;
            
            return true;
        }
        
        return false;
    }
    
    public boolean deleteFront() {
        if(head != null) {
            head = head.link;
            
            currSize--;
            
            return true;
        }
        
        return false;
    }
    
    public boolean deleteLast() {
        if(head != null) {
            Node temp = head;
            Node prev = null;
            if(head.link == null) {
                head = null;
            } else {
                while(temp.link != null) {
                    prev = temp;
                    temp = temp.link;
                }
            
                prev.link = null;
            }
            
            currSize --;
            
            return true;
        }
        
        return false;
    }
    
    public int getFront() {
        if(head == null)
            return -1;
        return head.data;
    }
    
    public int getRear() {
        Node temp = head;
        
        if(head == null)
            return -1;
        
        while(temp.link != null)
            temp = temp.link;
        
        return temp.data;
    }
    
    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(currSize == size)
            return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */