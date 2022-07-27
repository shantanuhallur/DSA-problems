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
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1==NULL && list2==NULL) return list1 == NULL? list2:list1;
        ListNode* dummy = new ListNode(-1);
        ListNode* prev= dummy;
        ListNode* c1 = list1 ;
        ListNode* c2 = list2;
        
        while(c2!=NULL && c1!=NULL){
            if(c1->val<=c2->val){
              prev->next = c1; 
                c1=c1->next;
            }
            else{
                prev->next = c2; 
                c2=c2->next;
            }
            prev=prev->next;
        }
        prev->next= c1==NULL?c2:c1;
        // c1==null?prev.next=c2:prev.next=c1;
        
        return dummy->next;
    }
};