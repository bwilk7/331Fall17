cpdef double avg_c( nums):
    total = 0.0
    for i in nums:
        total += i
    return total/len(nums)
