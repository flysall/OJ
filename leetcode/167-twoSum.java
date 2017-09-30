class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] re = new int[2];
        while(left < right){
            int mid = (left + right) / 2;
            if(numbers[left] + numbers[right] == target){
                re[0] = left + 1;
                re[1] = right + 1;
                break;
            }else if(numbers[left] + numbers[right] < target){
                if(numbers[mid] + numbers[right] <= target){
                    left = mid;
                } else if(numbers[mid] + numbers[right] > target){
                    left++;
                }
            }else if(numbers[left] + numbers[right] > target){
                if(numbers[mid] + numbers[left] >= target){
                    right = mid;
                } else if(numbers[mid] + numbers[left] < target){
                    right--;
                }
            }
        }
        return re;
    }
}