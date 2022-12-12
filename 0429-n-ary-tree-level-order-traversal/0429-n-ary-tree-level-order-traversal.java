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
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        
        while(q.size()!=0) {
            int size = q.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while(size-->0) {
                Node rn = q.removeFirst();
                for(Node child:rn.children) {
                    q.addLast(child);
                }
                smallAns.add(rn.val);
            }
            ans.add(smallAns);
        }
        return ans;
    }
}