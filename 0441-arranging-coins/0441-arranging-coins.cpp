class Solution {
public:
    int arrangeCoins(int n) 
    {
        return (-1+sqrt(1.0+4.0*2.0*n))/2;
    }
};