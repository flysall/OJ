public class Solution{
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		if(nums1.length == 0 && nums2.length == 0)
			return 0.0;
		int[] num = new int[nums1.length + nums2.length];
		int m = 0, n = 0;
		for(int i = 0; i < num.length; i++){
			if(m >= nums1.length){
				num[i] = nums2[n];
				n++;
			} else if(n >= nums2.length){
				num[i] = nums1[m];
				m++;
			} else{
				if(nums1[m] <= nums2[n]){
					num[i] = nums1[m];
					m++;
				} else{
					num[i] = nums2[n];
					n++;
				}
			}
		}
		if(num.length % 2 != 0)
			return (double) num[(num.length - 1) / 2];
		else{
			double a = (double) num[num.length / 2];
			double b = (double) num[num.length / 2 - 1];
			return (a + b) / 2;
		}
	}
}