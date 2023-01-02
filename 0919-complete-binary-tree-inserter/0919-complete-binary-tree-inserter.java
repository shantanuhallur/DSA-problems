/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode dummyRoot;
    LinkedList<TreeNode> que;
    TreeNode currPtr = null;
    public CBTInserter(TreeNode root) {
        dummyRoot = root;
        que = new LinkedList<>();
        que.addLast(root);
        //LEVEL ORDER
        while(true) {
            TreeNode rn = que.peekFirst();
            currPtr = rn;
            
            if(rn.left !=null) que.addLast(rn.left);
            else break;
            
            if(rn.right !=null) que.addLast(rn.right);
            else break;
            
            que.removeFirst();
        }
    }
    
    public int insert(int val) {
        int returnVal = currPtr.val;
        //if left child doesnt exist
        if(currPtr.left ==null) {
            TreeNode node = new TreeNode(val);
            currPtr.left = node;
            que.addLast(node);
        }
        else{ // left child exists
            TreeNode node = new TreeNode(val);
            currPtr.right = node;
            que.addLast(node); //add usefull node
            que.removeFirst(); //remove useless node
            currPtr = que.peekFirst(); //reset currPtr in que
        }
        
        return returnVal;
    }
    
    public TreeNode get_root() {
        return dummyRoot;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */