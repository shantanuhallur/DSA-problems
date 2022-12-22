/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(root== null) return ans;
        
        LinkedList<Node> st = new LinkedList<>();
        st.addLast(root);
        
        while(st.size()!=0) {
            Node rn = st.removeLast();
            
            for(Node child : rn.children) {
                st.addLast(child);
            }
            
            ans.addFirst(rn.val);
        }
        return ans;
    }
}