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
        HashSet<Integer> set = new HashSet<>();
        Node temp1 = p;
        while(temp1!=null) {
            set.add(temp1.val);
            if(temp1 == q) return temp1;
            temp1 = temp1.parent;
        }
        //check if p is in the parent path of q or if qs path has one common node of ps path
        temp1 = q;
        while(temp1!=null) {
            if(temp1 == p || set.contains(temp1.val)) return temp1;
            temp1 = temp1.parent;
        }
        return null;
    }
}