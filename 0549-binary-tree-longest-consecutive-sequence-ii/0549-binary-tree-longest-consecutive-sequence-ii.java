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
    public class pair{
        int inc;
        int dec;
        pair(int inc,int dec) {
            this.inc = inc;
            this.dec = dec;
        }
    }
    int maxLen = -1;
    public pair getLCS(TreeNode node) {
        // if(node == null) return new pair(0,0);
        //faith to get maxIncreasing and decreasing length of PATH passing *THROUGH* my left and right node.
        //or else max length anyhow carries the maxLen of any random max path.
        int  leftInc = 1 , leftDec = 1;
        int rightInc = 1, rightDec = 1;
        
        if(node.left!=null) {
            pair lAns = getLCS(node.left);
            if(node.val == node.left.val +1) {
                leftInc = lAns.inc + 1;
            }
            else if(node.val +1 == node.left.val) {
                leftDec = lAns.dec +1;
            }
        }
        
        if(node.right!=null) {
            pair rAns = getLCS(node.right);
            if(node.val == node.right.val+1) {
                rightInc = rAns.inc + 1;
            }
            else if(node.val + 1 == node.right.val) {
                rightDec = rAns.dec + 1;
            }
        }
        
        int maxInc = Math.max(leftInc,rightInc);
        int maxDec = Math.max(leftDec,rightDec);
        
        maxLen = Math.max(maxLen,Math.max(maxInc,maxDec));
        maxLen = Math.max(maxLen,maxInc+maxDec -1);
        
        return new pair(maxInc,maxDec);
    }
    public int longestConsecutive(TreeNode root) {
        getLCS(root);
        return maxLen;
    }
}