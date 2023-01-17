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
    TreeNode prev = null;
    int count = 1;
    int max = -1;
    public void getNodes(TreeNode node,ArrayList<Integer> ans) {
        if(node==null) return;
        getNodes(node.left,ans);
        if(prev != null) {
            if(node.val == prev.val) {
                count++;
            }
            else {
                count = 1;
            }
        }
        
        if(count>max) {
            ans.clear();
            ans.add(node.val);
            max = count;
        }
        else if(count == max) {
            ans.add(node.val);
        }
        prev = node;
        getNodes(node.right,ans);
    }
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        getNodes(root,ans);
        int[] retAns = new int[ans.size()];
        for(int i=0;i<retAns.length;i++){
            retAns[i] = ans.get(i);
        }
        return retAns;
    }
}