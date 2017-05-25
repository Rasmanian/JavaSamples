/* One more check in to Branch 2 */

class Solution
{ 
	 // Assuming this is a Binary Search Tree
     class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int value) {
            data = value;
        }

        public void addNode(int value)
        {
            TreeNode tn = new TreeNode(value);
            if (value < this.data) { 
                if (this.left != null) this.left.addNode(value); 
                else this.left = tn;
            }
            else { 
                if (this.right != null) this.right.addNode(value); 
                else this.right = tn;
            }
        }
        
        public static TreeNode findCommonNode(TreeNode a, TreeNode b){
            if (this.data == a.data || this.data == b.data) return this;
            
            TreeNode lCommonNode = this.left.findCommonNode(a,b);
            TreeNode rCommonNode = this.right.findCommonNode(a,b);
            
            if ( lCommonNode != null && rCommonNode != null)
                    return this;
            else if ( lCommonNode != null)
            {
                return lCommonNode;
            }
            else if (rCommonNode != null)
            {
            	return rCommonNode;
            }
            // both are null; Nodes are not part of the left or right sub tree
            return null;
        }
        
        
        public static int findDistance(TreeNode fromNode, TreeNode node)
        {
            if (fromNode.data == node.data) return 0;
          
                if (node.data < fromNode.data) 
                	return findDistance(fromNode.left, node) + 1;
                else 
                    return findDistance(fromNode.right, node) + 1;
        }
    }
    

    
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static void main()
	{
		int[] values = {5,3,6,1,4,2};
		int node1 = 2;
		int node2 = 4;
		int n = 5;
	    //if (n < 2 ) return -1;
	    //if (n != values.length) return -1;
	    
	    try {
	   	    TreeNode root = new TreeNode(values[0]);
    	    for (int i = 1; i < n; i++)
    	    {
    		 root.addNode(values[i]);
    	    }
    	    
    	    TreeNode common = TreeNode.findCommonNode(new TreeNode(node1), new TreeNode(node2));
    	    return common.findDistance(new TreeNode(node1)) + common.findDistance(new TreeNode(node2));
	    } catch(Exception e) {
	        e.printStackTrace();
	        return -1;
	    } finally {
	    }


	}
	
	
	// METHOD SIGNATURE ENDS
}
