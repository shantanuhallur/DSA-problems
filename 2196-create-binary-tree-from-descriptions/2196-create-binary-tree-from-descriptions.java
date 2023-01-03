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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        //add frequencies and create all nodes.
        for(int[] node : descriptions) {
            int parent = node[0]; int child = node[1]; int isLeft = node[2];
            TreeNode par = map.getOrDefault(parent,new TreeNode(parent));
            map.put(parent,par);
            
            if(isLeft==1) {
                par.left = map.getOrDefault(child,new TreeNode(child));
                map.put(child,par.left);
            }
            else{
                par.right = map.getOrDefault(child,new TreeNode(child));
                map.put(child,par.right);
            }
            
            freq.put(child,1);
        }
         // Return root;  
         for(int[] node : descriptions) {
             if(!freq.containsKey(node[0])) return map.get(node[0]);
         }   
        return null;
    }
}