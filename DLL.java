


// Implementing a DLL LinkedList

class DLL
{
    class Node
    {
        int data;
        Node next;
        Node prev; // FOR DLL
        
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
        void reverse()
        {
            Node temp = this.next;
            this.next = this.prev;
            this.prev = temp;
        }
    }
    
    // DLL needs a head node
    private Node head = null;
    
    public void addToEnd(int data)
    {
        // Set head to the start node
        if (head == null)
        {
            Node node = new Node(data);
            head = node;
        }
        else
        {
            Node current = head;
            // store the old head node (top of stack)
            while (current.next != null)
            {
                current = current.next;
            }

            Node node = new Node(data);
            node.prev = current;
            current.next = node;
        }

    }
    
    
    public void reverseDLL()
    {
        if (head == null)
        {
           return;
        }
        else
        {
            reverseNode(head);
        }
    }
    
    public void reverseNode(Node node)
    {
        if (node.next != null)
        {
            reverseNode(node.next);
        }
        else 
        {
            this.head = node;
        }
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
    }
    
    
    public void printDLL()
    {
        Node movingHead = head;
        while (movingHead != null)
        {
            System.out.println(movingHead.data);
            movingHead = movingHead.next;
        }
    }
    
    
    public static void main(String[] args) throws Exception
    {
        DLL dll=new DLL(); 
        dll.addToEnd(20); dll.addToEnd(50); 
        dll.addToEnd(80); dll.addToEnd(40); 
        dll.addToEnd(60); 
        dll.addToEnd(75); 
        //System.out.println("Element removed from LinkedList: "+lls.pop()); 
        //System.out.println("Element removed from LinkedList: "+lls.pop()); 
        dll.addToEnd(10); 
        // System.out.println("Element removed from LinkedList: "+lls.pop()); 
        dll.printDLL();
        
        dll.reverseDLL();
        dll.printDLL();
    }

}