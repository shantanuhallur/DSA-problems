/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class pair {
        int data;
        int height;
        pair(int data, int height) {
            this.data = data;
            this.height = height;
        }
        
    }
    public int ans=0;
    public pair longestUnivaluePath_01(TreeNode node) {
      if(node == null) return new pair(0,0);
        
        pair leftAns = longestUnivaluePath_01(node.left);
        pair rightAns = longestUnivaluePath_01(node.right);
        
        pair myPair = new pair(node.val,1);
        //Cases
        if(node.val == leftAns.data && node.val == rightAns.data) {
            ans = Math.max(ans,leftAns.height+rightAns.height+1);
            myPair.height = Math.max(1,Math.max(leftAns.height,rightAns.height)+1);
            
        }
        else if(node.val == leftAns.data) {
            ans = Math.max(ans,Math.max(leftAns.height + 1 , rightAns.height));
            int myHeight = leftAns.height + 1; 
            myPair.height = myHeight;
        }
        else if(node.val == rightAns.data) {
            ans = Math.max(ans,Math.max(leftAns.height, rightAns.height + 1));
            int myHeight = rightAns.height + 1; 
            myPair.height = myHeight;
        }
        else {
            ans = Math.max(1,ans);
        }
        
        return myPair;
    }
// ans -> storing longest length in overall tree of same nodes
// myPair.height storing longest height from *CURRENT* node to left *or* right 
// --> if in myPair 3 cases arise
//1->if l=r=me ->myMax height will be max(l,r) + 1
//2 -> if l=me -> myMaxHeight will be 1+leftHeight 
//3 -> if r=me -> myMaxHeight will be 1+rightHeight
// --> if in total ans 3 cases will arise
// -->if l=r=me ansMax will be max(ans,lh+rh+1)
//  -->if l=me ansMax will be max(ans,lh+1,rh)
//  -->if r=me ansMax will be max(ans,rh+1,lh)
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longestUnivaluePath_01(root);
        return ans-1;  
    }
}