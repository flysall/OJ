import java.util.Random;

public class Sort {
    static Random rand = new Random();  // The Random is without seed, or it will be pseudo-random.
    /**
     * 快速排序
     */
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
        int j = low-1;
        swap(nums, high, low+rand.nextInt(high-low+1)); // Make sure pivot is random.
        for(int i = low; i < high; i++) {
            if(nums[i] <= nums[high]) {     // nums[high] is the pivot.
                swap(nums, i, ++j);
            }
        }
        swap(nums, ++j, high);
        // Now the pivot is moved from high to j, elements that are in the left of pivot are less than pivot 
        // and elements that are in the right of pivot are bigger than pivot.
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
    public static void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right){
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
        while(j <= right)
            numsResult[k++] = nums[j++];
        j--; k--;
        while(k >= 0)
            nums[j--] = numsResult[k--];
    }

    /**
     * 堆排序
     */
    static int sizeOfHeap;
    public static void heapSort(int[] array) {
        sizeOfHeap = array.length;
        if(sizeOfHeap < 1) 
            return;
        buildMaxHeap(array);
        while(sizeOfHeap > 0) {
            swap(array, 0, sizeOfHeap-1);
            sizeOfHeap--;
            adjustHeap(array, 0);
        }
    }
    
    private static void buildMaxHeap(int[] array) {
        for(int i = (sizeOfHeap-1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 有左子树，且左子树大于maxIndex节点
        if(i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        // 有右子树，且右子树大于maxIndex节点
        if(i * 2 + 2< len && array[i * 2 + 2] > array[maxIndex])
            maxIndex = i * 2 + 2;        
        if(maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
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


    /**
     * 计数排序
     */
    public static void countingSort(int[] array) {
        if(array.length == 0) 
            return;
        int bias, min = array[0], max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) 
                max = array[i];
            if(array[i] < min) 
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        for(int i = 0; i < array.length; i++) 
            bucket[array[i] + bias]++;
        int index = 0, i = 0;
        while(index < array.length) {
            if(bucket[i] != 0) {
                array[index++] = i - bias;
                bucket[i]--;
            } else {    
                i++;
            }
        }
    }


    /**
     * 桶排序
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if(array == null || array.size() < 2)
            return arrray;
        int max = array.get(0), min = array.get(0);
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) > max) 
                max = array.get(i);
            if(array.get(i) < min) 
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(int i = 0; i < bucketCount; i++) 
            bucketArr.add(new ArrayList<Integer>());
        for(int i = 0; i < array.size(); i++) 
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        for(int i = 0; i < bucketCount; i++) {
            if(bucketCount == 1)
                bucketSize--;
            ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
            for(int j = 0; j < temp.size(); j++)
                resultArr.add(temp.get(j));
        }
        return resultArr;
    }

    /**
     * 基数排序
     */
    public static void radixSort(int[] array) {
        if(array == null || array.length < 2)
            return;
        int max = array[0];
        for(int i = 1; i < array.length; i++)
            max = Math.max(max, array[i]);
        int maxDigit = 0;
        while(max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for(int i = 0; i < 10; i++) 
            bucketList.add(new ArrayList<Integer>());
        for(int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for(int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for(int j = 0; j < bucketList.size(); j++) {
                for(int k = 0; k < bucketList.get(j).size(); k++) 
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
    }
}