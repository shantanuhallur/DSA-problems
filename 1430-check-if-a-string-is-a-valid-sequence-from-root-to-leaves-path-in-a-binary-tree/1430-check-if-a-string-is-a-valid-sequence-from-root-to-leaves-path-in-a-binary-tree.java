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
    public void getSeq(TreeNode node,StringBuilder sb) {
        if(node == null) {
            return;
        }
        sb.append(node.val);
        if(node.left==null && node.right==null) {
            list.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        getSeq(node.left,sb);
        getSeq(node.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
         StringBuilder sb = new StringBuilder();
         getSeq(root,sb);
        // for(String s : list) System.out.print(s+" ");
        StringBuilder build = new StringBuilder();
        for(int i=0;i<arr.length;i++) build.append(String.valueOf(arr[i]));
        String check = build.toString();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals(check)) return true;
            
        }
        return false;
    }
}