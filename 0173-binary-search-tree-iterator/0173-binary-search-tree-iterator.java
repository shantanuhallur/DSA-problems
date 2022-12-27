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
class BSTIterator {
    LinkedList<TreeNode> st = new LinkedList<>();
    public void addAllLeftN(TreeNode curr) {
        //Base curr -> null
        if(curr == null) return;
        
        while(curr != null) {
            st.addLast(curr);
            curr = curr.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        addAllLeftN(root);
    }
    
    public int next() {
        TreeNode removeN = st.removeLast();
        //add all the left nodes of right of removeN.
        addAllLeftN(removeN.right);

        return removeN.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */