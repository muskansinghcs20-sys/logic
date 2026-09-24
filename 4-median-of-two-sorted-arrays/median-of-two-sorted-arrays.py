class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Always binary-search the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)

        left, right = 0, m
        half = (m + n + 1) // 2

        while left <= right:
            i = (left + right) // 2
            j = half - i

            # Boundary values
            nums1_left = float('-inf') if i == 0 else nums1[i - 1]
            nums1_right = float('inf') if i == m else nums1[i]

            nums2_left = float('-inf') if j == 0 else nums2[j - 1]
            nums2_right = float('inf') if j == n else nums2[j]

            # Correct partition
            if nums1_left <= nums2_right and nums2_left <= nums1_right:

                if (m + n) % 2 == 1:
                    return float(max(nums1_left, nums2_left))

                left_max = max(nums1_left, nums2_left)
                right_min = min(nums1_right, nums2_right)

                return (left_max + right_min) / 2.0

            # Move partition in nums1
            elif nums1_left > nums2_right:
                right = i - 1
            else:
                left = i + 1

        