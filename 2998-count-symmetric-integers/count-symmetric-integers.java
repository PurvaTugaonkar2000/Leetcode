class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <=high; i++){
            String str = String.valueOf(i);
            int x = str.length();
            int sum1 = 0, sum2 = 0;
            for(int j = 0; j<x/2; j++){
                sum1 += (int) str.charAt(j);
            }
            for(int j = x/2; j<x; j++){
                sum2 += (int) str.charAt(j);
            }
            if(sum1 == sum2){
                count++;
            }
        }
        return count;
    }
}