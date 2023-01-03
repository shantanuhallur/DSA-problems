/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(Node node,int[] freq) {
        //Base Case
        if(node==null) return;
        //condition to check if i dont have a + in the node
        if(node.val != '+') freq[node.val-'a']++;
        //recurse to left and right side to cover the whole tree
        dfs(node.left,freq);
        dfs(node.right,freq);
        
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] freq = new int[26];
        dfs(root1,freq);
        dfs(root2,freq);
        //if any freq is odd return false else return true;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0) return false;
        }
        return true;
    }
}