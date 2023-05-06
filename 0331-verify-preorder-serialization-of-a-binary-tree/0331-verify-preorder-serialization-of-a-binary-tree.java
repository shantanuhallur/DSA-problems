class Solution {
public:
    bool isValidSerialization(string preorder) {
        stringstream ss(preorder);
        string element;
        int diff = 1;
        while(getline(ss,element,',')) {
            if(--diff<0) return false;
            if(element!="#")diff+=2;
        }
        return diff==0;
    }
};