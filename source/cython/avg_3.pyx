cpdef double avg_c(nums):
    cdef double total = 0.0
    cdef double i
    for i in nums:
        total += i
    return total/len(nums)
