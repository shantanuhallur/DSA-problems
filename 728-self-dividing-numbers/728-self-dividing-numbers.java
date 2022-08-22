class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDivNos = new ArrayList<>();
        
        for(int i=left ; i<=right;i++){
          int j=i; 
            for(j=i;j>0;j/=10){ //j == (j%10) == last digit;
                if((j%10==0) ||i%(j%10)!=0){
                    break;
                }
            }
            if(j==0)selfDivNos.add(i);
        }
        return selfDivNos;
    }
    
    
}