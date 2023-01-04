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
    public int PresentAt(TreeNode node,int p,int q) {
        if(node == null)return 0;
        
        int leftCount = PresentAt(node.left,p,q);
        int rightCount = PresentAt(node.right,p,q);
        
        int myCount = 0;
        if(node.val == p || node.val == q) myCount++;
        
        return leftCount+rightCount+myCount;
    }
    public int kDown(TreeNode node,int val, int len) {
        if(node==null) return 0;
        if(node.val==val) return len;
        
        int leftLen = kDown(node.left,val,len+1);
        if(leftLen >0) return leftLen;
        int rightLen = kDown(node.right,val,len+1);
        if(rightLen>0) return rightLen;
        
        return leftLen+rightLen;
    }
    public int findDistance(TreeNode root, int p, int q) {
        if(p==q) return 0;
        
        if(PresentAt(root.left,p,q) ==  2) {
            return findDistance(root.left,p,q);
        }
        else if(PresentAt(root.right,p,q) ==  2) {
            return findDistance(root.right,p,q);
        }
        else { //pq passes through this node
            int lenP = kDown(root,p,0);
            int lenQ = kDown(root,q,0);
            return lenP+lenQ;
        }
    }
}