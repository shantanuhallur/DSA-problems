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
    void dfs(Node node,int[] alphabet) {
        if(node==null)return;
        
        if(node.val !='+') alphabet[node.val-'a']++;
        
        dfs(node.left,alphabet);
        dfs(node.right,alphabet);
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] alphabet = new int[26];
        
        dfs(root1,alphabet);
        dfs(root2,alphabet);
        
        for(int i=0;i<26;i++) {
            if(alphabet[i]%2!=0) return false;
        }
        return true;
    }
}