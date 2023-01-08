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
    int camera = 0;
    // -1 i need a camera
    //1 i am covered.
    // 0 i dont need a camera
    
    public int capture(TreeNode node) {
        if(node == null) return 0;
        
        int left = capture(node.left);
        int right = capture(node.right);
        
        if(left == -1 || right == -1) {
            camera++;
            return 1;
        }
        
        if(left == 1 || right == 1) return 0;
            
        return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        int check = capture(root);
        if(check == -1) camera++;
        return camera;
    }
}