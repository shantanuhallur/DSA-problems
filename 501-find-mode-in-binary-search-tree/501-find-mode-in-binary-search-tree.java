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
    Integer prev = null;
    int count=1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        traverse(root,list);
        
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void traverse(TreeNode node,ArrayList<Integer> modes){
        if(node==null)return;
        //inOrder = left root rigt;
        traverse(node.left,modes);
        if(prev!=null){
            if(prev == node.val){
                count++;
            }
            else{
                count=1;
            }
        }
        
        if(count>max){
            max = count;
            modes.clear();
            modes.add(node.val); 
        }
        else if(count==max){
            modes.add(node.val); 
        }
        
        prev = node.val;
        
        traverse(node.right,modes);
    }
}