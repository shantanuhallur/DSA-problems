/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
     //-1 -> im not covered
    //0 -> im covered
    //1 -> im a camera and im also covered. 
     //null nodes are alredy in covered state.
    //one of my child node is not covered i will compulsory have to attach a camera to my node
      //check if my child is a camera
    // both left and right nodes are covered-> (0) but im not covered(my Node) return -1;
    //check if root is covered or not
    int cameras = 0;
    int getInfo(TreeNode* node) {
         //null nodes are alredy in covered state.
        if(!node) return 0;
        
        int leftInfo = getInfo(node->left);
        int rightInfo = getInfo(node->right);
        //one of my child node is not covered i will compulsory have to attach a camera to my node
        if(leftInfo == -1 || rightInfo == -1) {
            cameras++;
            return 1;
        }
         //check if my child is a camera
        if(leftInfo == 1 || rightInfo == 1) return 0;
        // both left and right nodes are covered-> (0) but im not covered(my Node) return -1;
        return -1;
    } 
    int minCameraCover(TreeNode* root) {
        //check if root is covered or not
        int rootInfo = getInfo(root);
        if(rootInfo == -1) cameras++;
        return cameras;
    }
};