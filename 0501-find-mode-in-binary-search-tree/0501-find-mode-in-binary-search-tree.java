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
    int maxFreq = -1;
    TreeNode prev = null;
    int nodeFreq = 1;
    void inOrder(TreeNode node,ArrayList<Integer> ans) {
        //BaseCase
        if(node==null) return;
        
        //left and right recursive calls
        inOrder(node.left,ans);
        if(prev != null) {
            if(prev.val == node.val) {
                nodeFreq++; // increase node freq because we have got a node with same value
            }
            else { // we have got a new value node set its freq to 1
                nodeFreq = 1;
            }
        }
        //if our nodeFreq > maaxFreq
        if(maxFreq<nodeFreq) {
            ans.clear(); //there can be already element added with a previous maxFreq
            ans.add(node.val);
            maxFreq=nodeFreq;
        }
        else if(maxFreq == nodeFreq) { //there will be multiple answers
            ans.add(node.val);
        }
        
        prev = node;
        inOrder(node.right,ans);
        
    }
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        //convert the answer in int[]
        int[] retAns = new int[ans.size()];
        for(int i=0;i<retAns.length;i++) {
            retAns[i] = ans.get(i);
        }
        return retAns;
    }
}