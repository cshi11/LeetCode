package main

import (
	"fmt"
	"math"
)
// duvide 本题不能使用乘除，即要求用位运算代替， << 左移 n 位等价与乘以 2^n ,但是 2^n 到最后时候每一步跨度太大，
// 因此需要从头再开始，类似递归思想
// 过程： 100/3
// 求 max(3 * (1 + 2 + 4 + ... + i)) < 100, 得 i 16， res = sum(i) = 31, 余 100 - 93 = 7
// 求 max(3 * (1 + 2 + ...)) < 7, 得 i 1， res = 32, 余 4
// 继续， 得 i 1 ，res 33 ,余 1 < 3, 结束
// 从头求 3 * 2^i <= 4, 得 i = 0, res = 32 + 

// 更硬核做法，直接手工实现计算机二进制除法 https://blog.csdn.net/zdavb/article/details/47108505


func divide(dividend int, divisor int) int {
	// 判断结果正负的方法
	positive :=  (dividend < 0) == (divisor < 0)

	dividend = int(math.Abs(float64(dividend)))
	divisor = int(math.Abs(float64(divisor)))

	res := 0
	for dividend >= divisor{
		temp, i := divisor, 1
		fmt.Println(res)
		for dividend >= temp{
			dividend -= temp
			res += i
			i <<= 1
			temp <<= 1
		}
	}
	if !positive{
		res = -res
	}
	return int(math.Min(math.Max(-2147483648, float64(res)), 2147483647))
}

func main(){
	res := divide(100, 3)
	fmt.Println(res)
}