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
        //p is parent of q
        Node temp1 = q;
        HashSet<Node> set = new HashSet<>();
        while(temp1!=null){
            if(temp1 == p) return p;
            temp1 = temp1.parent;
            set.add(temp1);
        }
        
        //q is parent of p
        Node temp2 = p;
        while(temp2!=null){
            if(temp2 == q || set.contains(temp2)) return temp2;
            temp2 = temp2.parent;
        }
        
        return null;
    }
}