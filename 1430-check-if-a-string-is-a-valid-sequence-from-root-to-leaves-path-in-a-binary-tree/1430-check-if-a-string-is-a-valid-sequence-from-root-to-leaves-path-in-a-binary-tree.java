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
    ArrayList<String> list = new ArrayList<>();
    public void getSeq(TreeNode node,String psf) {
        if(node == null) {
            return;
        }
        psf += node.val;
        if(node.left==null && node.right==null) {
            list.add(psf);
            return;
        }
        getSeq(node.left,psf);
        getSeq(node.right,psf);
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
         getSeq(root,"");
        // for(String s : list) System.out.print(s+" ");
        String check = "";
        for(int i=0;i<arr.length;i++) check+= String.valueOf(arr[i]);
            
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals(check)) return true;
        }
        return false;
    }
}