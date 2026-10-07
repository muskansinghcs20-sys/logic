class Solution(object):
    def divide(self, dividend, divisor):
        # overflow case
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1

        # sign nikal lo
        negative = (dividend < 0) ^ (divisor < 0)
        
        a = abs(dividend)
        b = abs(divisor)
        result = 0

        # jaise 10/3 = 10-3-3-3 = 1 bacha, par fast karne ke liye doubling karenge
        while a >= b:
            temp = b
            multiple = 1
            while a >= (temp << 1):
                temp <<= 1
                multiple <<= 1
            a -= temp
            result += multiple

        if negative:
            result = -result

        return result