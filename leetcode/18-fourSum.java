 class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int sum3 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;
                int sum2 = sum3 - nums[j];
                int k = j + 1, w = nums.length - 1;
                while (k < w) {
                    if (nums[k] + nums[w] > sum2)
                        w--;
                    else if (nums[k] + nums[w] < sum2)
                        k++;
                    else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[w]));
                        w--;
                        k++;
                        while (k < w && nums[k] == nums[k - 1]) k++;
                        while (k < w && nums[w] == nums[w + 1]) w--;
                    }
                }
            }
        }
        return list;
    }
}
