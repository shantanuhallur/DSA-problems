/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> set = new  HashSet<>();
        Node temp1 = p;
        while(temp1!=null) {
            if(temp1==q) return temp1;
            set.add(temp1.val);
            temp1=temp1.parent;
        }
        Node temp2 = q;
        while(temp2!=null) {
            if(temp2==p || set.contains(temp2.val)) return temp2;
            temp2 = temp2.parent;
        }
        return null;
    }
}