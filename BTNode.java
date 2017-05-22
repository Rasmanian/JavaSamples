// Binary TreeNode storing Integer Data
import java.util.*;


class BTNode
{

    int data;
    BTNode left;
    BTNode right;
    
    int minLeafDepth = 0;
    int maxLeafDepth = 0;

    public BTNode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public BTNode addLeft(int data)
    {
        this.left = new BTNode(data);
        return left;
    }

    public BTNode addRight(int data)
    {
        this.right = new BTNode(data);
        return right;
    }
    
    
    // TO DO AN ITERATIVE solution, Create a java.util.Stack<BTNode> and add the Root node to the stack;
    // Pop the root node and print it; then push the Right Node of the root, followed by the Left Node of the root 
    // again into the stack. Repeat the same logic in a loop until the stack is empty.
    
    public void printPreOrder()  
    {
        System.out.println(this.data);
        if ( this.left != null ) this.left.printPreOrder();   
        if ( this.right != null )this.right.printPreOrder();   
    }
    
    public void printInOrder()
    {
        if ( this.left != null ) this.left.printInOrder();   
        System.out.println(this.data);
        if ( this.right != null ) this.right.printInOrder();   
    }
    
    public void printPostOrder()
    {
        if ( this.left != null ) this.left.printPostOrder();   
        if ( this.right != null ) this.right.printPostOrder();   
        System.out.println(this.data);
    }
    
    public void printPathsToLeaf(List<String> path)
    {
        // Add root Node value to arrayList
        // if left and right are Null, leaf reached. Print the array List
        // Recursivley call the same function on the left and right node by making two copies of the array List 
        // Release the memory for the current ArrayList
        if (path == null) path = new ArrayList<String>();
        path.add(String.valueOf(this.data));


        if (this.left == null && this.right == null)
        {
            for (String val : path)
            {
                System.out.println(val);
            }
            System.out.println("===");
            path = null; 
            return;
        }
        
        if (this.left != null) 
        {
            this.left.printPathsToLeaf(new ArrayList(path));
        }
        
        if (this.right != null) 
        {
            this.right.printPathsToLeaf(new ArrayList(path));
        }
        
    }
    
    public void getLeafDepths(List<Integer> depth, int myDepth)
    {
        if (depth == null) depth = new ArrayList<String>();

        if (this.left == null && this.right == null)
        {
        	depth.add(new Integer(myDepth)); 
        	return;
        }
        
        if (this.left != null) 
        {
            this.left.getLeafDepths(depth, myDepth + 1);
        }
        
        if (this.right != null) 
        {
            this.right.getLeafDepths(depth, myDepth + 1);
        }
    }
    
    public static boolean isSuperBalanced(BTNode node, int depth)
    {
    	// getLeafDepths
    }
    

    public static void main (String[] args)
    {
        BTNode root = new BTNode(1);
        BTNode rl = root.addLeft(2);
        BTNode rr = root.addRight(3);
        BTNode rll = rl.addLeft(4);
        BTNode rrl = rr.addLeft(5);
        BTNode rrr = rr.addRight(6);
        
        root.printPathsToLeaf(null);
        
        System.out.println("PRE ORDER");
        root.printPreOrder();
        
        System.out.println("IN ORDER");
        root.printInOrder();
        
        System.out.println("POST ORDER");
        root.printPostOrder();

    }
    
}
