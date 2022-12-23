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
    TreeNode h = null;
    TreeNode currPtr = null;
    Queue<TreeNode> que = new LinkedList<>();
    
    public CBTInserter(TreeNode root) {
        h = root;
        que.add(root);
        
        while(true) {
            TreeNode rn = que.peek();
            currPtr = que.peek();
            if(rn.left !=null) {
                que.add(rn.left);
            }
            else break;
            
            if(rn.right !=null) {
                que.add(rn.right);
            }
            else break;
            
            que.poll();
        }
        
        
    }
    
    public int insert(int val) {
        int rnVal = currPtr.val;
        if(currPtr.left == null){
            TreeNode node = new TreeNode(val);
            currPtr.left = node;
            que.add(node);
        }
        else{
            TreeNode node = new TreeNode(val);
            currPtr.right = node;
            que.add(node);
            rnVal = currPtr.val;
            que.poll();
            currPtr = que.peek();
            
        }
        return rnVal;
    }
    
    public TreeNode get_root() {
        return h;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */