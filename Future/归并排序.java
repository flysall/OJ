class MergeSort {
    public void MergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            MergeSort(nums, left, mid);
            MergeSort(nums, mid+1, right);
            Merge(nums, left, mid, right);
        }
    }
    private void Merge(int[] nums, int left, int mid, int right){
        int i = left, j = mid + 1, k = 0;
        int[] numsResult = new int[right - left + 1];
        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                numsResult[k++] = nums[i++];
            }
            else{
                numsResult[k++] = nums[j++];
            }
        }
        while(i <= mid)
            numsResult[k++] = nums[i++]; 
        while( j <= right)
            numsResult[k++] = nums[j++];
        j--; k--;
        while(k >= 0)
            nums[j--] = numsResult[k--];
    }
}





