class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer it : nums){
            if(it.equals(max1) || it.equals(max2) || it.equals(max3))
                continue;
            if(max1 == null || it > max1){
                max3 = max2;
                max2 = max1;
                max1 = it;
            }
            if(max2 == null || it > max2){
                max3 = max2;
                max2 = it;
            }
            if(max3 == null || it > max3){
                max3 = it;
            }
        }
        return max3 == null ? max1 : max3;
    }
}