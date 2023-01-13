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
class Solution {//binary for checking 2d - 1 th node and binary search for deciding to go left or right in depth
    public int getDepth(TreeNode node) {
        int depth = 0;
        while(node.left!=null) {
            node = node.left;
            ++depth;
        }
        return depth;
    }
    
    public boolean exists(TreeNode node,int d, int idx) {
        int left = 0 , right = (int) Math.pow(2,d) -1;
        
        for(int i=0;i<d;i++) {
            int mid= left + (right-left)/2;
            if(idx<=mid) {
                node = node.left;
                right = mid;
            }
            else{
                node = node.right;
                left = mid + 1;
            }
        }
        return node!=null;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int d = getDepth(root);
        if(d == 0) return 1;
        
        int left = 1, right = (int) Math.pow(2,d) -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(exists(root,d,mid)) left = mid+1;
            else right = mid-1;
            
        }
        
        return (int)Math.pow(2,d)-1 + left;
    }
}