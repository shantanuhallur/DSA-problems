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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        //Stack
        LinkedList<Node> st = new LinkedList<>();
        
        st.addLast(root);
        
        while(st.size()!=0) {
            Node removeN = st.removeLast();
            
            for(int i=removeN.children.size()-1 ; i >=0 ; i--) {
                st.addLast(removeN.children.get(i));
            }
            
            ans.add(removeN.val);
        }
        
        return ans;
    }
}