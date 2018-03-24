public class Sort {
    /**
     * 快速排序
     */
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


    /**
     * 插入排序
     */
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


    /**
     * 归并排序
     */
    public static void MergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            MergeSort(nums, left, mid);
            MergeSort(nums, mid+1, right);
            Merge(nums, left, mid, right);
        }
    }

    private static void Merge(int[] nums, int left, int mid, int right){
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


    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while(gap > 0) {
            for(int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }


    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        if(array.length == 0)
            return;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length-i-1; j++) {
                if(array[j+1] < array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public void selectionSort(int[] array) {
        if(array.length == 0)
            return;
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(j = i; j < array.length; j++) {
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }   
    }
}