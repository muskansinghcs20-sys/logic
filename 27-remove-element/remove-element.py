class Solution(object):
    def removeElement(self, nums, val):
        k = 0 # jahan tak val ke bina array bana hai
        for j in range(len(nums)):
            if nums[j]!= val:
                nums[k] = nums[j]
                k += 1
        return k
        