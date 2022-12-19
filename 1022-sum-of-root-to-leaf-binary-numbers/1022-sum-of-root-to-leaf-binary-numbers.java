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
    public void sumRootToLeaf_01(TreeNode node,List<LinkedList<Integer>> ans, LinkedList<Integer> smallAns) {
        if(node.left == null && node.right == null){
            LinkedList<Integer> base = new LinkedList<>(smallAns);
            base.addFirst(node.val);
            ans.add(base);
            
        }
        
        smallAns.addFirst(node.val);

        if(node.left != null) {
            sumRootToLeaf_01(node.left,ans,smallAns);
        }
        
        if(node.right != null) {
            sumRootToLeaf_01(node.right,ans,smallAns);
        }
        smallAns.removeFirst();
    }
    
    public int sumRootToLeaf(TreeNode root) {
        int finalAns = 0;
        LinkedList<Integer> smallAns = new LinkedList<>();
        List<LinkedList<Integer>> ans = new LinkedList<>();
        sumRootToLeaf_01(root,ans,smallAns);
        for(LinkedList<Integer> onePath : ans) {
            for(int i=0;i<onePath.size();i++) {
                if(onePath.get(i)==1){
                    finalAns += Math.pow(2,i);
                }
                
            }
        }
        return finalAns;
    }
}