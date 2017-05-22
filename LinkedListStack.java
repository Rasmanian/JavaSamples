


// Implementing a Stack using a LinkedList

class LinkedListStack
{
    class Node
    {
        int data;
        Node next;
        // Node Prev; // FOR DLL
        
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
    // Stack needs a head node
    private Node head = null;
    
    public void push(int data)
    {
        // store the old head node (top of stack)
        Node oldhead = head;
        head = new Node(data);
        head.next = oldhead;
    }
    
    public int pop() throws Exception
    {
        if (head == null) { throw new Exception("Stack Empty !!!"); }
            
        Node oldhead = head;
        head = head.next;
        return oldhead.data;
    }
    
    public void printStack()
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
        LinkedListStack lls=new LinkedListStack(); 
        lls.push(20); lls.push(50); lls.push(80); lls.push(40); lls.push(60); lls.push(75); 
        System.out.println("Element removed from LinkedList: "+lls.pop()); 
        System.out.println("Element removed from LinkedList: "+lls.pop()); 
        lls.push(10); System.out.println("Element removed from LinkedList: "+lls.pop()); 
        lls.printStack();
    }

}