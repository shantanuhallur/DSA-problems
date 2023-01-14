/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    TreeNode* buildBST(vector<int> arr,int st,int end) {
        if(st>end) return NULL;
        
        int mid = st + (end-st)/2;
        TreeNode* root = new TreeNode(arr[mid]);
        root->left = buildBST(arr,st,mid-1);
        root->right = buildBST(arr,mid+1,end);
        
        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head) return NULL;
        ListNode* curr = head;
        vector<int> arr;
        while(curr != NULL) {
            arr.push_back(curr->val);
            curr = curr->next;
        }
        return buildBST(arr,0,arr.size()-1);
    }
};