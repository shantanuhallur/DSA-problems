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
class Solution {
    List<Integer> sortedList = new ArrayList<>();
    public void inorder(TreeNode node) {
        if(node == null) return;
        
        inorder(node.left);
        sortedList.add(node.val);
        inorder(node.right);
        
    }
    
    public TreeNode balance(int st,int end) {
        if(st>end) return null;
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        
        root.left = balance(st,mid-1);
        root.right = balance(mid+1,end);
        
        
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return null;
        inorder(root);
        root = balance(0,sortedList.size()-1);
        return root;
    }
}