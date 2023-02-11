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
    //count pairs
    //Base Case
    //leaf case
    int countPairs = 0;
    int[] getLeafDist(TreeNode node,int d) {
        if(node == null) return new int[]{};
        //leaf case
        if(node.left == null && node.right == null) {
            int[] leaf = new int[1];
            leaf[0] = 1;
            return leaf;
        }
        
        //left and right recursive call for information
        int [] lAns = getLeafDist(node.left,d);
        int [] rAns = getLeafDist(node.right,d);
        //try to make pairs with all leaves if left and right
        for(int val1 : lAns) {
            for(int val2: rAns) {
                //check if our pair is valid
                if(val1+val2 <= d) countPairs++;
            }
        } 
    //distance upate for leaves to return to parent node;
    int n = lAns.length , m = rAns.length;
        int[] myAns = new int[n+m];
        int i = 0;
        for(int val : lAns) myAns[i++] = val+1;
        for(int val : rAns) myAns[i++] = val+1;
        //return this updated myAns to parent
        return myAns;
    }
    public int countPairs(TreeNode root, int distance) {
        getLeafDist(root,distance);
        return countPairs;
    }
}