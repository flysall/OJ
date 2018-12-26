class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(1, len(nums)):
            if nums[i-1] > 0:
                nums[i] += nums[i-1]
        return max(nums)
        
def main():
    while True:
        user_input = input("Enter your input like 1, 2, 3: ")
        char_list = user_input.split(",")
        int_list = [int(char_list[i]) for i in range(len(char_list))]
        s = Solution()
        res = s.maxSubArray(int_list)
        print("res is:", res)

if __name__ == "__main__":
    main()
