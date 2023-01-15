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
    TreeNode* buildTree(ListNode* head,ListNode* tail) {
        //Base Case
        if(head==tail) return NULL;
        //find root node to be created by finding mid of LL
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast!=tail && fast->next!=tail) {
            slow = slow->next; //move slow with 1 step
            fast = fast->next->next;//move fast with 2 steps
        }
        TreeNode* root = new TreeNode(slow->val);
        //left and right recursive calls
        root->left =  buildTree(head,slow);
        root->right = buildTree(slow->next,tail);
        //return root of this build tree
        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        if(head == NULL) return NULL;
        return buildTree(head,NULL);
    }
};