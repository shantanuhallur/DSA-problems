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
    public void inorder(ArrayList<Integer> sortedList,TreeNode node) {
        if(node == null) return;
        
        inorder(sortedList,node.left);
        sortedList.add(node.val);
        inorder(sortedList,node.right);
    }
    public TreeNode balance(ArrayList<Integer> sortedList,int st,int end) {
        if(st>end) return null;
        
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = balance(sortedList,st,mid-1);
        root.right = balance(sortedList,mid+1,end);
        
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        inorder(sortedList,root);
        root = balance(sortedList,0,sortedList.size()-1);
        return root;
    }
}