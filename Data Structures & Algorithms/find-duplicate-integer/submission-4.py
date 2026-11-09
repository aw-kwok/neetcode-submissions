class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = nums[0], nums[nums[0]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
        
        curr = 0
        while curr != slow:
            slow = nums[slow]
            curr = nums[curr]
        return slow