public class Sort {



    static Random rand = new Random();
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if(low >= high)
            return;
        int mid = partition(nums, low, high);
        quickSort(nums, low, mid-1);
        quickSort(nums, mid+1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int i = low, j = low-1;
        swap(nums, high, low+rand.nextInt(high-low+1)); // Make sure pivot is random.
        for(; i < high; i++) {
            if(nums[i] <= nums[high]) {     // nums[high] is the pivot.
                swap(nums, i, ++j);
            }
        }
        swap(nums, ++j, high);
        return j;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   

    public static void insertSort(int[] a) {
        if(a == null || a.length <= 1)
            return;
        int left = 1, right = a.length - 1;
        for(int i = left; i <= right; i++) {
            int tmp = a[i], j = i-1;
            for( ; j >= 0 && a[j] > tmp; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = tmp;
        }
    }



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