/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void serialize(TreeNode node,StringBuilder sb) {
        if(node == null) return ;
        sb.append(node.val).append(",");
        serialize(node.left,sb);
        serialize(node.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    int idx = 0;
    public TreeNode buildBST(int[] preorder,int lRange,int rRange) {
        //Base Case
        if(idx == preorder.length || preorder[idx] < lRange || preorder[idx]>rRange) return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        //Recursive faith calls for left and right nodes of root.
        root.left = buildBST(preorder,lRange,root.val);
        root.right = buildBST(preorder,root.val,rRange);
        
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        System.out.print(list);
        int[] preorder =new int[list.size()];
        int i =0; 
        while(i<preorder.length){
            preorder[i] = Integer.parseInt(list.get(i)); 
            i++;
        }
        return buildBST(preorder,-1,(int)1e5);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;