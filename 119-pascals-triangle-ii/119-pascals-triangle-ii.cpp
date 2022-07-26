class Solution {
public:
    vector<int> getRow(int rowIndex) {
       
     vector<int> res;
        int i=rowIndex;
        long val=1;
        for(int j=0;j<=i;j++){
            res.push_back(val);
        val=val*(i-j)/(j+1);    //formula to generate val of next row
        }
        return res;
    
    }
};