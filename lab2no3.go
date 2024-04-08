package main

import (
	"fmt"
)

func checkTimeFormat(num int) bool {
	if num < 100 {
		return false
	}
	hours := num / 100
	minutes := num % 100

	if hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59 {
		return true
	} else {
		return false
	}
}

func main() {
	var count, num int
	fmt.Scan(&count)

	for i := 0; i < count; i++ {
		fmt.Scan(&num)
		if num == -1 {
			break
		}
		if checkTimeFormat(num) {
			fmt.Println("YES")
		} else {
			fmt.Println("NO")
		}
	}
}
