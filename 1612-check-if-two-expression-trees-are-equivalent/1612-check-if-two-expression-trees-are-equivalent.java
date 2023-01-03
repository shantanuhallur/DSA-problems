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
    public String evaluate(Node node){
        if(node ==null) return "";
        
        String leftVal = evaluate(node.left);
        String rightVal = evaluate(node.right);
        
        String myVal = leftVal+node.val+rightVal;
        return myVal;
    }
    public boolean checkAnagram(String s1,String s2) {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character ch:s1.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Character ch:s2.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        
        for(int value:map.values()) {
            if(value<0) return false;
        }
        return true;
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        String s1 = evaluate(root1);
        String s2 = evaluate(root2);
        return checkAnagram(s1,s2);
    }
}