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
class FindElements {
    HashSet<Integer> set;
    public void recoverTree(TreeNode node,int idx) {
        //Base Case
        if(node == null) return;
        //set this nodes val to our passed idx
        node.val = idx;
        set.add(idx);
        //Left and Right recursive calls
        recoverTree(node.left,2*idx+1);
        recoverTree(node.right,2*idx+2);
    }
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        recoverTree(root,0);
    }
    
    public boolean find(int target) {
        return set.contains(target) ? true : false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */